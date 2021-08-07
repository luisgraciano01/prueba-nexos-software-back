package co.com.nexossoftware.pruebatecnica.dto;

import java.io.Serializable;

/**
 * Objeto de respuesta en la consulta de un usuario.<br/>
 * <br/>
 * Creado el 07-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public class UsuarioOutDto implements Serializable {

	/** @see {@link Serializable} class */
	private static final long serialVersionUID = 1772103973922298023L;

	/** Identificador único del usuario. */
	private Integer idUsuario;

	/** Nombre completo del usuario. */
	private String nombre;

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

}
