package co.com.nexossoftware.pruebatecnica.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.nexossoftware.pruebatecnica.controller.UsuarioController;
import co.com.nexossoftware.pruebatecnica.dto.RespuestaDto;
import co.com.nexossoftware.pruebatecnica.service.UsuarioService;

/**
 * Clase {@link RestController} que implmenta la interfaz
 * {@link UsuarioController}.<br/>
 * Esta clase es la encargada de definir y exponer los edpoints relacionados con
 * <b>usuario</b>.<br/>
 * <br/>
 * Creado el 07-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
@RestController("UsuarioController")
@RequestMapping(path = "/usuario")
@CrossOrigin(origins = "*")
public class UsuarioControllerImpl implements UsuarioController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioControllerImpl.class);

	/**
	 * Instancia de la clase que implementa la interface {@link UsuarioService}.
	 */
	@Autowired
	private UsuarioService usuarioService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.nexossoftware.pruebatecnica.controller.UsuarioController#findAll()
	 */
	@Override
	@GetMapping(path = "/findAll")
	public ResponseEntity<RespuestaDto> findAll() {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new RespuestaDto(true, null, this.usuarioService.findAll()));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new RespuestaDto(false, "Ha ocurrido un error durante la consulta de los usuarios."));
		}
	}

}
