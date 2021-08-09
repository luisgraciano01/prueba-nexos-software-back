package co.com.nexossoftware.pruebatecnica.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.nexossoftware.pruebatecnica.dto.MercanciaOutDto;
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

}
