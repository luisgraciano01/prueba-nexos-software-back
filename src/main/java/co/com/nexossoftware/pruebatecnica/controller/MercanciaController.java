package co.com.nexossoftware.pruebatecnica.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;

import co.com.nexossoftware.pruebatecnica.dto.EditarMercanciaInDto;
import co.com.nexossoftware.pruebatecnica.dto.EliminarMercanciaInDto;
import co.com.nexossoftware.pruebatecnica.dto.MercanciaOutDto;
import co.com.nexossoftware.pruebatecnica.dto.RegistrarMercanciaInDto;
import co.com.nexossoftware.pruebatecnica.dto.RespuestaDto;

/**
 * Interfaz para el controlador que maneja los endpoints asociados con la
 * mercancía.<br/>
 * <br/>
 * Creado el 08-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public interface MercanciaController {

	/**
	 * Endpoint que obtiene la lista de mercancías registradas en la base de datos
	 * filtrado por nombre producto, usuario registra, y fecha ingreso.
	 * 
	 * @param nombreProducto    Nombre del producto.
	 * @param idUsuarioRegistra Identificador del usuario que registró la mercancía.
	 * @param fechaIngreso      Fecha de ingreso de la mercancía.
	 * @return Objeto {@link ResponseEntity} con una lista de
	 *         {@link MercanciaOutDto}.<br/>
	 *         <br/>
	 *         Ejemplo 1: HTTP Status 200<br/>
	 *         {@code { "estado" true, "data": [ {"idMercancia": 1,
	 *         "nombreProducto": "Llanta 195/65R15 91H FSR801", "cantidad": "15",
	 *         "fechaIngreso": "2021-05-24", "fechaRegistro": "2021-05-24 14:23:10",
	 *         "usuario": { "idUsuario": 1, "nombre": "Luis Graciano"}} ] } } <br/>
	 *         <br/>
	 *         Ejemplo 2: HTTP Status 200<br/>
	 *         {@code { "estado" false, "mensaje": "Ha ocurrido un error durante la
	 *         consulta de las mercancías." } } <br/>
	 */
	public ResponseEntity<RespuestaDto> findByMultipleCriteria(String nombreProducto, Integer idUsuarioRegistra, Date fechaIngreso);

	/**
	 * Endpoint que verifica si existe mercancía registrada con un nombre de
	 * producto determinada.
	 * 
	 * @param nombreProducto Nombre del producto.
	 * @return - {@code true} si existe la mercancía.<br/>
	 *         - {@code false} si no existe la mercancía.<br/>
	 *         <br/>
	 *         Ejemplo 1: HTTP Status 200<br/>
	 *         {@code { "estado" true, "data": true } } <br/>
	 *         <br/>
	 *         Ejemplo 2: HTTP Status 200<br/>
	 *         {@code { "estado" true, "data": false } } <br/>
	 *         <br/>
	 *         Ejemplo 3: HTTP Status 200<br/>
	 *         {@code { "estado" false, "mensaje": "Ha ocurrido un error durante la
	 *         consulta de la mercancía." } } <br/>
	 */
	public ResponseEntity<RespuestaDto> checkIfExistsMercancia(String nombreProducto);

	/**
	 * Endpoint que guarda en base de datos una mercancía.
	 * 
	 * @param registrarMercanciaInDto Datos de la mercancía a registrar.
	 * @return - {@code true} si se registró la mercancía.<br/>
	 *         - {@code false} si no se registró la mercancía.<br/>
	 *         <br/>
	 *         Ejemplo 1: HTTP Status 200<br/>
	 *         {@code { "estado" true, "data": true } } <br/>
	 *         <br/>
	 *         Ejemplo 2: HTTP Status 200<br/>
	 *         {@code { "estado" true, "data": false } } <br/>
	 *         <br/>
	 *         Ejemplo 3: HTTP Status 200<br/>
	 *         {@code { "estado" false, "mensaje": "Ha ocurrido un error durante el
	 *         registro de la mercancía." } } <br/>
	 */
	public ResponseEntity<RespuestaDto> save(RegistrarMercanciaInDto registrarMercanciaInDto);

	/**
	 * Endpoint que obtiene los datos de una mercancía registrada en la base de
	 * datos.
	 * 
	 * @param idMercancia Identificador de la mercancía.
	 * @return Objeto {@link ResponseEntity} con un objeto
	 *         {@link MercanciaOutDto}.<br/>
	 *         <br/>
	 *         Ejemplo 1: HTTP Status 200<br/>
	 *         {@code { "estado" true, "data": {"idMercancia": 1,
	 *         "nombreProducto": "Llanta 195/65R15 91H FSR801", "cantidad": "15",
	 *         "fechaIngreso": "2021-05-24", "fechaRegistro": "2021-05-24 14:23:10",
	 *         "usuario": { "idUsuario": 1, "nombre": "Luis Graciano" } } } } <br/>
	 *         <br/>
	 *         Ejemplo 2: HTTP Status 200<br/>
	 *         {@code { "estado" true, "data": null } } <br/>
	 *         <br/>
	 *         Ejemplo 3: HTTP Status 200<br/>
	 *         {@code { "estado" false, "mensaje": "Ha ocurrido un error durante la
	 *         consulta de la mercancía." } } <br/>
	 */
	public ResponseEntity<RespuestaDto> findById(Integer idMercancia);

	/**
	 * Endpoint que actualiza en base de datos una mercancía.
	 * 
	 * @param editarMercanciaInDto Datos de la mercancía a actualizar.
	 * @return - {@code true} si se registró la mercancía.<br/>
	 *         - {@code false} si no se registró la mercancía.<br/>
	 *         <br/>
	 *         Ejemplo 1: HTTP Status 200<br/>
	 *         {@code { "estado" true, "data": true } } <br/>
	 *         <br/>
	 *         Ejemplo 2: HTTP Status 200<br/>
	 *         {@code { "estado" true, "data": false } } <br/>
	 *         <br/>
	 *         Ejemplo 3: HTTP Status 200<br/>
	 *         {@code { "estado" false, "mensaje": "Ha ocurrido un error durante la
	 *         actualización de la mercancía." } } <br/>
	 */
	public ResponseEntity<RespuestaDto> update(EditarMercanciaInDto editarMercanciaInDto);

	/**
	 * Endpoint que elimina en base de datos una mercancía.
	 * 
	 * @param eliminarMercanciaInDto Datos de la mercancía a eliminar.
	 * @return - {@code true} si eliminó la mercancía.<br/>
	 *         - {@code false} si no eliminó la mercancía.<br/>
	 *         <br/>
	 *         Ejemplo 1: HTTP Status 200<br/>
	 *         {@code { "estado" true, "data": true } } <br/>
	 *         <br/>
	 *         Ejemplo 2: HTTP Status 200<br/>
	 *         {@code { "estado" true, "data": false } } <br/>
	 *         <br/>
	 *         Ejemplo 3: HTTP Status 200<br/>
	 *         {@code { "estado" false, "mensaje": "Ha ocurrido un error durante la
	 *         eliminación de la mercancía." } } <br/>
	 */
	public ResponseEntity<RespuestaDto> delete(EliminarMercanciaInDto eliminarMercanciaInDto);

}
