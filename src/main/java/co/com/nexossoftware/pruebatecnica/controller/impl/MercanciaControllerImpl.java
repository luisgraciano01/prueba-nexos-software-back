package co.com.nexossoftware.pruebatecnica.controller.impl;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.nexossoftware.pruebatecnica.controller.MercanciaController;
import co.com.nexossoftware.pruebatecnica.dto.RegistrarMercanciaInDto;
import co.com.nexossoftware.pruebatecnica.dto.RespuestaDto;
import co.com.nexossoftware.pruebatecnica.service.MercanciaService;

/**
 * Clase {@link RestController} que implmenta la interfaz
 * {@link MercanciaController}.<br/>
 * Esta clase es la encargada de definir y exponer los edpoints relacionados con
 * <b>mercancia</b>.<br/>
 * <br/>
 * Creado el 08-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
@RestController("MercanciaController")
@RequestMapping(path = "/mercancia")
@CrossOrigin(origins = "*")
public class MercanciaControllerImpl implements MercanciaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MercanciaControllerImpl.class);

	/**
	 * Instancia de la clase que implementa la interface {@link MercanciaService}.
	 */
	@Autowired
	private MercanciaService mercanciaService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.nexossoftware.pruebatecnica.controller.MercanciaController#
	 * findByMultipleCriteria(java.lang.String, java.lang.Integer, java.util.Date)
	 */
	@Override
	@GetMapping(path = "/findByMultipleCriteria")
	public ResponseEntity<RespuestaDto> findByMultipleCriteria(
			@RequestParam(required = false) String nombreProducto,
			@RequestParam(required = false) Integer idUsuarioRegistra,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIngreso) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new RespuestaDto(true, null,
							this.mercanciaService.findByMultipleCriteria(nombreProducto, idUsuarioRegistra, fechaIngreso)));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new RespuestaDto(false, "Ha ocurrido un error durante la consulta de  las mercancías."));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.nexossoftware.pruebatecnica.controller.MercanciaController#
	 * checkIfExistsMercancia(java.lang.String)
	 */
	@GetMapping(path = "/checkIfExistsMercancia")
	@Override
	public ResponseEntity<RespuestaDto> checkIfExistsMercancia(@RequestParam(required = true) String nombreProducto) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new RespuestaDto(true, null,
							this.mercanciaService.existeMercancia(nombreProducto)));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new RespuestaDto(false, "Ha ocurrido un error durante la consulta de  las mercancías."));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.nexossoftware.pruebatecnica.controller.MercanciaController#save(co.com
	 * .nexossoftware.pruebatecnica.dto.RegistrarMercanciaInDto)
	 */
	@Override
	@PostMapping(path = "/save")
	public ResponseEntity<RespuestaDto> save(@Valid @RequestBody RegistrarMercanciaInDto registrarMercanciaInDto) {
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new RespuestaDto(true, null,
							this.mercanciaService.save(registrarMercanciaInDto)));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new RespuestaDto(false, "Ha ocurrido un error durante el registro de la mercancía."));
		}
	}

}
