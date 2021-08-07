package co.com.nexossoftware.pruebatecnica.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidad para la tabla <b>cargo</b>.<br/>
 * <br/>
 * Creado el 07-08-2021.
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
@Entity(name = "CargoEntity")
@Table(name = "cargo")
public class CargoEntity {

	/**
	 * Identificador único del cargo.
	 */
	@Id
	@Column(name = "id_cargo")
	private Integer idCargo;

	/**
	 * Nombre del cargo.
	 */
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;

	/** Lista de usuarios asociados a este cargo. */
	@OneToMany(mappedBy = "cargoEntity", fetch = FetchType.LAZY)
	private List<UsuarioEntity> usuarioEntityList;

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
	 * Retorna el valor de la propiedad {@link #usuarioEntityList}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @return {@link List<UsuarioEntity>}, con el valor de la propiedad
	 *         {@link #usuarioEntityList}.</b>
	 */
	public List<UsuarioEntity> getUsuarioEntityList() {
		return usuarioEntityList;
	}

	/**
	 * Asigna un valor a la propiedad {@link #usuarioEntityList}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @param usuarioEntityList Un valor de tipo {@link List<UsuarioEntity>} a
	 *                          asignar a la propiedad {@link #usuarioEntityList}.
	 */
	public void setUsuarioEntityList(List<UsuarioEntity> usuarioEntityList) {
		this.usuarioEntityList = usuarioEntityList;
	}

}
