package co.com.nexossoftware.pruebatecnica.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditarMercanciaInDto implements Serializable {

	/**
	 * @see {@link Serializable} class
	 */
	private static final long serialVersionUID = -8258078162273751369L;

	/**
	 * Identificador de la mercancía.
	 */
	@NotNull(message = "Propiedad 'idMercancia' requerida.")
	@Min(value = 1, message = "Propidad 'idMercancia' debe ser mayor o igual a 1.")
	private Integer idMercancia;

	/**
	 * Identificador del usuario que registra la mercancía.
	 */
	@NotNull(message = "Propiedad 'idUsuarioActualiza' requerida.")
	@Min(value = 1, message = "Propidad 'idUsuarioActualiza' debe ser mayor o igual a 1.")
	private Integer idUsuarioActualiza;

	/**
	 * Nombre del producto.
	 */
	@NotNull(message = "Propiedad 'nombreProducto' requerida.")
	@NotBlank(message = "Propiedad 'nombreProducto' no debe contener solo espacios.")
	private String nombreProducto;

	/**
	 * Cantidad que ingresa.
	 */
	@NotNull(message = "Propiedad 'cantidad' requerida.")
	@Min(value = 1, message = "Propidad 'cantidad' debe ser mayor o igual a 1.")
	private Integer cantidad;

	/**
	 * Fecha de ingreso.
	 */
	@NotNull(message = "Propiedad 'fechaIngreso' requerida.")
	private Date fechaIngreso;

	/**
	 * Retorna el valor de la propiedad {@link #idMercancia}.<br/>
	 * <br/>
	 * Creado el 09-08-2021.
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
	 * Creado el 09-08-2021.
	 *
	 * @param idMercancia Un valor de tipo {@link Integer} a asignar a la propiedad
	 *                    {@link #idMercancia}.
	 */
	public void setIdMercancia(Integer idMercancia) {
		this.idMercancia = idMercancia;
	}

	/**
	 * Retorna el valor de la propiedad {@link #idUsuarioActualiza}.<br/>
	 * <br/>
	 * Creado el 09-08-2021.
	 *
	 * @return {@link Integer}, con el valor de la propiedad
	 *         {@link #idUsuarioActualiza}.</b>
	 */
	public Integer getIdUsuarioActualiza() {
		return idUsuarioActualiza;
	}

	/**
	 * Asigna un valor a la propiedad {@link #idUsuarioActualiza}.<br/>
	 * <br/>
	 * Creado el 09-08-2021.
	 *
	 * @param idUsuarioActualiza Un valor de tipo {@link Integer} a asignar a la
	 *                           propiedad {@link #idUsuarioActualiza}.
	 */
	public void setIdUsuarioActualiza(Integer idUsuarioActualiza) {
		this.idUsuarioActualiza = idUsuarioActualiza;
	}

	/**
	 * Retorna el valor de la propiedad {@link #nombreProducto}.<br/>
	 * <br/>
	 * Creado el 09-08-2021.
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
	 * Creado el 09-08-2021.
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
	 * Creado el 09-08-2021.
	 *
	 * @return {@link Integer}, con el valor de la propiedad {@link #cantidad}.</b>
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * Asigna un valor a la propiedad {@link #cantidad}.<br/>
	 * <br/>
	 * Creado el 09-08-2021.
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
	 * Creado el 09-08-2021.
	 *
	 * @return {@link Date}, con el valor de la propiedad {@link #fechaIngreso}.</b>
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * Asigna un valor a la propiedad {@link #fechaIngreso}.<br/>
	 * <br/>
	 * Creado el 09-08-2021.
	 *
	 * @param fechaIngreso Un valor de tipo {@link Date} a asignar a la propiedad
	 *                     {@link #fechaIngreso}.
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
