package co.com.nexossoftware.pruebatecnica.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Objeto de entrada en la eliminación de una mercancía.<br/>
 * <br/>
 * Creado el 07-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EliminarMercanciaInDto implements Serializable {

	/**
	 * @see {@link Serializable} class
	 */
	private static final long serialVersionUID = 3744466557321713046L;

	/**
	 * Identificador de la mercancía.
	 */
	@NotNull(message = "Propiedad 'idMercancia' requerida.")
	@Min(value = 1, message = "Propidad 'idMercancia' debe ser mayor o igual a 1.")
	private Integer idMercancia;

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

}
