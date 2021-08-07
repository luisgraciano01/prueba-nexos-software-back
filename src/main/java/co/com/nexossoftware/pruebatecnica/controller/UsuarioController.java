package co.com.nexossoftware.pruebatecnica.controller;

import org.springframework.http.ResponseEntity;

import co.com.nexossoftware.pruebatecnica.dto.RespuestaDto;
import co.com.nexossoftware.pruebatecnica.dto.UsuarioOutDto;

/**
 * Interfaz para el controlador que maneja los endpoints asociados con un
 * usuario.<br/>
 * <br/>
 * Creado el 07-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public interface UsuarioController {

	/**
	 * Endpoint que obtiene la lista de usuarios registrados en la base de datos.
	 * 
	 * @return Objeto {@link ResponseEntity} con una lista de
	 *         {@link UsuarioOutDto}.<br/>
	 *         <br/>
	 *         Ejemplo 1: HTTP Status 200<br/>
	 *         {@code { "estado" true, "data": [ {"idUsuario": 1, "nombre": "Luis
	 *         Graciano} ] } } <br/>
	 *         <br/>
	 *         Ejemplo 2: HTTP Status 500<br/>
	 *         {@code { "estado" false, "mensaje": "Ha ocurrido un error durante la
	 *         consulta de los usuarios." } } <br/>
	 */
	public ResponseEntity<RespuestaDto> findAll();

}
