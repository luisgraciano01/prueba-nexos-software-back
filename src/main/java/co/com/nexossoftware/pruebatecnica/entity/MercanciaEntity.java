package co.com.nexossoftware.pruebatecnica.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidad para la tabla <b>mercancia</b>.<br/>
 * <br/>
 * Creado el 80-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
@Entity(name = "MercanciaEntity")
@Table(name = "mercancia")
public class MercanciaEntity {

	/**
	 * Identificador único de la mercancia.
	 */
	@Id
	@SequenceGenerator(name = "seq_mercancia", sequenceName = "seq_mercancia", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mercancia")
	@Column(name = "id_mercancia", nullable = false)
	private Integer idMercancia;

	/**
	 * Identificador del usuario que registra la mercancia.
	 */
	@Column(name = "id_usuario_registra", nullable = false)
	private Integer idUsuarioRegistra;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_usuario_registra", nullable = false, insertable = false, updatable = false)
	private UsuarioEntity usuarioRegistraEntity;

	/**
	 * Nombre del producto que ingresa en la mercancia.
	 */
	@Column(name = "nombre_producto", length = 100, nullable = false)
	private String nombreProducto;

	/**
	 * Cantidad del producto ingresado en la mercancia.
	 */
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	/**
	 * Fecha de ingreso de la mercancía en el inventario.
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso", nullable = false)
	private Date fechaIngreso;

	/**
	 * Fecha de registro de la mercancía en la base datos.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro", nullable = false, updatable = false)
	private Date fechaRegistro;

	/**
	 * Identificador del último usuario que actualizón la mercancia.
	 */
	@Column(name = "id_usuario_actualiza", nullable = true)
	private Integer idUsuarioActualiza;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_usuario_actualiza", nullable = false, insertable = false, updatable = false)
	private UsuarioEntity usuarioActualizaEntity;

	/**
	 * Fecha de la última actualización de la mercancía en la base datos.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion", nullable = true)
	private Date fechaActualizacion;

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
	 * Retorna el valor de la propiedad {@link #idUsuarioRegistra}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @return {@link Integer}, con el valor de la propiedad
	 *         {@link #idUsuarioRegistra}.</b>
	 */
	public Integer getIdUsuarioRegistra() {
		return idUsuarioRegistra;
	}

	/**
	 * Asigna un valor a la propiedad {@link #idUsuarioRegistra}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @param idUsuarioRegistra Un valor de tipo {@link Integer} a asignar a la
	 *                          propiedad {@link #idUsuarioRegistra}.
	 */
	public void setIdUsuarioRegistra(Integer idUsuarioRegistra) {
		this.idUsuarioRegistra = idUsuarioRegistra;
	}

	/**
	 * Retorna el valor de la propiedad {@link #usuarioRegistraEntity}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @return {@link UsuarioEntity}, con el valor de la propiedad
	 *         {@link #usuarioRegistraEntity}.</b>
	 */
	public UsuarioEntity getUsuarioRegistraEntity() {
		return usuarioRegistraEntity;
	}

	/**
	 * Asigna un valor a la propiedad {@link #usuarioRegistraEntity}.<br/>
	 * <br/>
	 * Creado el 08-08-2021.
	 *
	 * @param usuarioRegistraEntity Un valor de tipo {@link UsuarioEntity} a asignar
	 *                              a la propiedad {@link #usuarioRegistraEntity}.
	 */
	public void setUsuarioRegistraEntity(UsuarioEntity usuarioRegistraEntity) {
		this.usuarioRegistraEntity = usuarioRegistraEntity;
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
	 * Retorna el valor de la propiedad {@link #usuarioActualizaEntity}.<br/>
	 * <br/>
	 * Creado el 09-08-2021.
	 *
	 * @return {@link UsuarioEntity}, con el valor de la propiedad
	 *         {@link #usuarioActualizaEntity}.</b>
	 */
	public UsuarioEntity getUsuarioActualizaEntity() {
		return usuarioActualizaEntity;
	}

	/**
	 * Asigna un valor a la propiedad {@link #usuarioActualizaEntity}.<br/>
	 * <br/>
	 * Creado el 09-08-2021.
	 *
	 * @param usuarioActualizaEntity Un valor de tipo {@link UsuarioEntity} a
	 *                               asignar a la propiedad
	 *                               {@link #usuarioActualizaEntity}.
	 */
	public void setUsuarioActualizaEntity(UsuarioEntity usuarioActualizaEntity) {
		this.usuarioActualizaEntity = usuarioActualizaEntity;
	}

	/**
	 * Retorna el valor de la propiedad {@link #fechaActualizacion}.<br/>
	 * <br/>
	 * Creado el 09-08-2021.
	 *
	 * @return {@link Date}, con el valor de la propiedad
	 *         {@link #fechaActualizacion}.</b>
	 */
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * Asigna un valor a la propiedad {@link #fechaActualizacion}.<br/>
	 * <br/>
	 * Creado el 09-08-2021.
	 *
	 * @param fechaActualizacion Un valor de tipo {@link Date} a asignar a la
	 *                           propiedad {@link #fechaActualizacion}.
	 */
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

}
