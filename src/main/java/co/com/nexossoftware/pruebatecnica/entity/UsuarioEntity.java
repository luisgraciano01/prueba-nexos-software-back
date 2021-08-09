package co.com.nexossoftware.pruebatecnica.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidad para la tabla <b>usuario</b>.<br/>
 * <br/>
 * Creado el 07-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
@Entity(name = "UsuarioEntity")
@Table(name = "usuario")
public class UsuarioEntity {

	/**
	 * Identificador único del usuario.
	 */
	@Id
	@Column(name = "id_usuario")
	private Integer idUsuario;

	/**
	 * Nombre completo del usuario.
	 */
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	/**
	 * Edad del usuario.
	 */
	@Column(name = "edad", nullable = false)
	private Integer edad;

	/**
	 * Identificador del cargo asociado del usuario.
	 */
	@Column(name = "id_cargo", nullable = false)
	private Integer idCargo;

	/**
	 * Entidad del cargo asociado del usuario.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_cargo", nullable = false, insertable = false, updatable = false)
	private CargoEntity cargoEntity;

	/**
	 * Fecha de ingreso del usuario a la empresa.
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso_empresa", nullable = false)
	private Date fechaIngresoEmpresa;

	/**
	 * Fecha de registro del usuario en la base datos.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro", nullable = false, updatable = false)
	private Date fechaRegistro;

	/**
	 * Lista de mercancías registradas por el usuario.
	 */
	@OneToMany(mappedBy = "usuarioRegistraEntity", fetch = FetchType.LAZY)
	private List<MercanciaEntity> mercanciaEntityList;

	/**
	 * Retorna el valor de la propiedad {@link #idUsuario}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @return {@link Integer}, con el valor de la propiedad {@link #idUsuario}.</b>
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Asigna un valor a la propiedad {@link #idUsuario}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @param idUsuario Un valor de tipo {@link Integer} a asignar a la propiedad
	 *                  {@link #idUsuario}.
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Retorna el valor de la propiedad {@link #nombre}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @return {@link String}, con el valor de la propiedad {@link #nombre}.</b>
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna un valor a la propiedad {@link #nombre}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @param nombre Un valor de tipo {@link String} a asignar a la propiedad
	 *               {@link #nombre}.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Retorna el valor de la propiedad {@link #edad}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @return {@link Integer}, con el valor de la propiedad {@link #edad}.</b>
	 */
	public Integer getEdad() {
		return edad;
	}

	/**
	 * Asigna un valor a la propiedad {@link #edad}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @param edad Un valor de tipo {@link Integer} a asignar a la propiedad
	 *             {@link #edad}.
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	/**
	 * Retorna el valor de la propiedad {@link #idCargo}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @return {@link Integer}, con el valor de la propiedad {@link #idCargo}.</b>
	 */
	public Integer getIdCargo() {
		return idCargo;
	}

	/**
	 * Asigna un valor a la propiedad {@link #idCargo}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @param idCargo Un valor de tipo {@link Integer} a asignar a la propiedad
	 *                {@link #idCargo}.
	 */
	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	/**
	 * Retorna el valor de la propiedad {@link #cargoEntity}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @return {@link CargoEntity}, con el valor de la propiedad
	 *         {@link #cargoEntity}.</b>
	 */
	public CargoEntity getCargoEntity() {
		return cargoEntity;
	}

	/**
	 * Asigna un valor a la propiedad {@link #cargoEntity}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @param cargoEntity Un valor de tipo {@link CargoEntity} a asignar a la
	 *                    propiedad {@link #cargoEntity}.
	 */
	public void setCargoEntity(CargoEntity cargoEntity) {
		this.cargoEntity = cargoEntity;
	}

	/**
	 * Retorna el valor de la propiedad {@link #fechaIngresoEmpresa}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @return {@link Date}, con el valor de la propiedad
	 *         {@link #fechaIngresoEmpresa}.</b>
	 */
	public Date getFechaIngresoEmpresa() {
		return fechaIngresoEmpresa;
	}

	/**
	 * Asigna un valor a la propiedad {@link #fechaIngresoEmpresa}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @param fechaIngresoEmpresa Un valor de tipo {@link Date} a asignar a la
	 *                            propiedad {@link #fechaIngresoEmpresa}.
	 */
	public void setFechaIngresoEmpresa(Date fechaIngresoEmpresa) {
		this.fechaIngresoEmpresa = fechaIngresoEmpresa;
	}

	/**
	 * Retorna el valor de la propiedad {@link #fechaRegistro}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
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
	 * Creado el 07-08-2021.
	 *
	 * @param fechaRegistro Un valor de tipo {@link Date} a asignar a la propiedad
	 *                      {@link #fechaRegistro}.
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
