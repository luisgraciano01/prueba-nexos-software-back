package co.com.nexossoftware.pruebatecnica.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.nexossoftware.pruebatecnica.dto.EditarMercanciaInDto;
import co.com.nexossoftware.pruebatecnica.dto.MercanciaOutDto;
import co.com.nexossoftware.pruebatecnica.dto.RegistrarMercanciaInDto;
import co.com.nexossoftware.pruebatecnica.dto.UsuarioOutDto;
import co.com.nexossoftware.pruebatecnica.entity.MercanciaEntity;
import co.com.nexossoftware.pruebatecnica.repository.MercanciaRepository;
import co.com.nexossoftware.pruebatecnica.service.MercanciaService;

/**
 * Clase {@link Service} que implmenta la interfaz
 * {@link MercanciaService}.<br/>
 * Esta clase es la encargada de gestionar la información de los mercancías.
 * <br/>
 * <br/>
 * Creado el 08-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
@Service("MercanciaService")
public class MercanciaServiceImpl implements MercanciaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MercanciaServiceImpl.class);

	/**
	 * Instancia de la implementación del repositorio de {@link MercanciaEntity}.
	 */
	@Autowired
	private MercanciaRepository mercanciaRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.nexossoftware.pruebatecnica.service.MercanciaService#
	 * findByMultipleCriteria(java.lang.String, java.lang.Integer, java.util.Date)
	 */
	@Override
	public List<MercanciaOutDto> findByMultipleCriteria(String nombreProducto, Integer idUsuarioRegistra, Date fechaIngreso) {
		return this.mercanciaRepository
				.findByMultipleCriteria(
						nombreProducto,
						idUsuarioRegistra,
						fechaIngreso != null ? new SimpleDateFormat("dd/MM/yyyy").format(fechaIngreso) : null)
				.stream()
				.map(mercancia -> {
					MercanciaOutDto mercanciaOutDto = new MercanciaOutDto();
					mercanciaOutDto.setIdMercancia(mercancia.getIdMercancia());
					mercanciaOutDto.setNombreProducto(mercancia.getNombreProducto());
					mercanciaOutDto.setCantidad(mercancia.getCantidad());
					mercanciaOutDto.setFechaIngreso(mercancia.getFechaIngreso());
					mercanciaOutDto.setFechaRegistro(mercancia.getFechaRegistro());
					mercanciaOutDto.setUsuarioRegistra(new UsuarioOutDto());
					mercanciaOutDto.getUsuarioRegistra().setIdUsuario(mercancia.getUsuarioRegistraEntity().getIdUsuario());
					mercanciaOutDto.getUsuarioRegistra().setNombre(mercancia.getUsuarioRegistraEntity().getNombre());

					return mercanciaOutDto;
				})
				.collect(Collectors.toList());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.nexossoftware.pruebatecnica.service.MercanciaService#existeMercancia(
	 * java.lang.String)
	 */
	@Override
	public boolean existeMercancia(String nombreProducto) {
		return this.mercanciaRepository.findByNombreProducto(nombreProducto).orElse(null) != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.nexossoftware.pruebatecnica.service.MercanciaService#save(co.com.
	 * nexossoftware.pruebatecnica.dto.RegistrarMercanciaInDto)
	 */
	@Override
	public boolean save(RegistrarMercanciaInDto registrarMercanciaInDto) {
		try {
			if (!this.existeMercancia(registrarMercanciaInDto.getNombreProducto().trim())) {
				MercanciaEntity mercanciaEntity = new MercanciaEntity();
				mercanciaEntity.setIdUsuarioRegistra(registrarMercanciaInDto.getIdUsuarioRegistra());
				mercanciaEntity.setNombreProducto(registrarMercanciaInDto.getNombreProducto().trim());
				mercanciaEntity.setCantidad(registrarMercanciaInDto.getCantidad());
				mercanciaEntity.setFechaIngreso(registrarMercanciaInDto.getFechaIngreso());
				mercanciaEntity.setFechaRegistro(new Date());

				this.mercanciaRepository.save(mercanciaEntity);

				return true;
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.nexossoftware.pruebatecnica.service.MercanciaService#findById(java.
	 * lang.Integer)
	 */
	@Override
	public MercanciaOutDto findById(Integer idMercancia) {
		MercanciaEntity mercanciaEntity = this.mercanciaRepository.findById(idMercancia).orElse(null);

		if (mercanciaEntity != null) {
			MercanciaOutDto mercanciaOutDto = new MercanciaOutDto();
			mercanciaOutDto.setIdMercancia(mercanciaEntity.getIdMercancia());
			mercanciaOutDto.setNombreProducto(mercanciaEntity.getNombreProducto());
			mercanciaOutDto.setCantidad(mercanciaEntity.getCantidad());
			mercanciaOutDto.setFechaIngreso(mercanciaEntity.getFechaIngreso());
			mercanciaOutDto.setFechaRegistro(mercanciaEntity.getFechaRegistro());
			mercanciaOutDto.setUsuarioRegistra(new UsuarioOutDto());
			mercanciaOutDto.getUsuarioRegistra().setIdUsuario(mercanciaEntity.getUsuarioRegistraEntity().getIdUsuario());
			mercanciaOutDto.getUsuarioRegistra().setNombre(mercanciaEntity.getUsuarioRegistraEntity().getNombre());

			return mercanciaOutDto;
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.nexossoftware.pruebatecnica.service.MercanciaService#update(co.com.
	 * nexossoftware.pruebatecnica.dto.EditarMercanciaInDto)
	 */
	@Override
	public boolean update(EditarMercanciaInDto editarMercanciaInDto) {
		try {
			MercanciaEntity mercanciaEntity = this.mercanciaRepository.findById(editarMercanciaInDto.getIdMercancia()).orElse(null);

			if (mercanciaEntity != null) {
				mercanciaEntity.setNombreProducto(editarMercanciaInDto.getNombreProducto().trim());
				mercanciaEntity.setCantidad(editarMercanciaInDto.getCantidad());
				mercanciaEntity.setFechaIngreso(editarMercanciaInDto.getFechaIngreso());
				mercanciaEntity.setIdUsuarioActualiza(editarMercanciaInDto.getIdUsuarioActualiza());
				mercanciaEntity.setFechaActualizacion(new Date());

				this.mercanciaRepository.save(mercanciaEntity);

				return true;
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.nexossoftware.pruebatecnica.service.MercanciaService#delete(java.lang.
	 * Integer)
	 */
	@Override
	public boolean delete(Integer idMercancia) {
		try {
			this.mercanciaRepository.deleteById(idMercancia);

			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}

		return false;
	}

}
