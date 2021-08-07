package co.com.nexossoftware.pruebatecnica.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.nexossoftware.pruebatecnica.dto.UsuarioOutDto;
import co.com.nexossoftware.pruebatecnica.entity.UsuarioEntity;
import co.com.nexossoftware.pruebatecnica.repository.UsuarioRepository;
import co.com.nexossoftware.pruebatecnica.service.UsuarioService;

/**
 * Clase {@link Service} que implmenta la interfaz {@link UsuarioService}.<br/>
 * Esta clase es la encargada de gestionar la información de los usuarios. <br/>
 * <br/>
 * Creado el 07-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
@Service("UsuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	/**
	 * Instancia de la implementación del repositorio de {@link UsuarioEntity}.
	 */
	@Autowired
	private UsuarioRepository usuarioRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.nexossoftware.pruebatecnica.service.UsuarioService#findAll()
	 */
	@Override
	public List<UsuarioOutDto> findAll() {
		return this.usuarioRepository
				.findAll()
				.stream()
				.map(usuario -> {
					UsuarioOutDto usuarioOutDto = new UsuarioOutDto();
					usuarioOutDto.setIdUsuario(usuario.getIdUsuario());
					usuarioOutDto.setNombre(usuario.getNombre());
					return usuarioOutDto;
				})
				.collect(Collectors.toList());
	}

}
