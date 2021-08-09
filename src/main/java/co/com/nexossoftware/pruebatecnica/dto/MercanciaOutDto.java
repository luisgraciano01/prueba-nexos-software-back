package co.com.nexossoftware.pruebatecnica.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Objeto de respuesta en la consulta de la mercancía registrada.<br/>
 * <br/>
 * Creado el 07-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public class MercanciaOutDto implements Serializable {

	/**
	 * @see {@link Serializable} class
	 */
	private static final long serialVersionUID = 3556327786910660948L;

	/**
	 * Identificador de la mercancía.
	 */
	private Integer idMercancia;

	/**
	 * Datos del usuario que registró la mercancía.
	 */
	private UsuarioOutDto usuarioRegistra;

	/**
	 * Nombre del producto ingresado.
	 */
	private String nombreProducto;

	/**
	 * Cantidad del producto ingresado.
	 */
	private Integer cantidad;

	/**
	 * Fecha de ingreso de la mercancía.
	 */
	private Date fechaIngreso;

	/**
	 * Fecha de registro de la mercancía en la base de datos.
	 */
	private Date fechaRegistro;

	/**
	 * Retorna el valor de la propiedad {@link #idMercancia}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @return {@link Integer}, con el valor de la propiedad
	 *         {@link #idMercancia}.</b>
	 */
	public Integer getIdMercancia() {
		return idMercancia;
	}

	/**
	 * Asigna un valor a la propiedad {@link #idMercancia}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @param idMercancia Un valor de tipo {@link Integer} a asignar a la propiedad
	 *                    {@link #idMercancia}.
	 */
	public void setIdMercancia(Integer idMercancia) {
		this.idMercancia = idMercancia;
	}

	/**
	 * Retorna el valor de la propiedad {@link #usuarioRegistra}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @return {@link UsuarioOutDto}, con el valor de la propiedad
	 *         {@link #usuarioRegistra}.</b>
	 */
	public UsuarioOutDto getUsuarioRegistra() {
		return usuarioRegistra;
	}

	/**
	 * Asigna un valor a la propiedad {@link #usuarioRegistra}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @param usuarioRegistra Un valor de tipo {@link UsuarioOutDto} a asignar a la
	 *                        propiedad {@link #usuarioRegistra}.
	 */
	public void setUsuarioRegistra(UsuarioOutDto usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	/**
	 * Retorna el valor de la propiedad {@link #nombreProducto}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @return {@link String}, con el valor de la propiedad
	 *         {@link #nombreProducto}.</b>
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}

	/**
	 * Asigna un valor a la propiedad {@link #nombreProducto}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @param nombreProducto Un valor de tipo {@link String} a asignar a la
	 *                       propiedad {@link #nombreProducto}.
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	/**
	 * Retorna el valor de la propiedad {@link #cantidad}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @return {@link Integer}, con el valor de la propiedad {@link #cantidad}.</b>
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * Asigna un valor a la propiedad {@link #cantidad}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @param cantidad Un valor de tipo {@link Integer} a asignar a la propiedad
	 *                 {@link #cantidad}.
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Retorna el valor de la propiedad {@link #fechaIngreso}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @return {@link Date}, con el valor de la propiedad {@link #fechaIngreso}.</b>
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * Asigna un valor a la propiedad {@link #fechaIngreso}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @param fechaIngreso Un valor de tipo {@link Date} a asignar a la propiedad
	 *                     {@link #fechaIngreso}.
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * Retorna el valor de la propiedad {@link #fechaRegistro}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @return {@link Date}, con el valor de la propiedad
	 *         {@link #fechaRegistro}.</b>
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Asigna un valor a la propiedad {@link #fechaRegistro}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @param fechaRegistro Un valor de tipo {@link Date} a asignar a la propiedad
	 *                      {@link #fechaRegistro}.
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
