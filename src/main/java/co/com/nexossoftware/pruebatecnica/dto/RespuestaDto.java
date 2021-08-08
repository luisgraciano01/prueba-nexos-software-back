package co.com.nexossoftware.pruebatecnica.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Clase usada para responder a todas las peticiones del usuario, contiene una
 * variable estado para notificar que no hubo error y todo fue exitoso y una
 * propiedad de mensajes en caso de que se le quiera enviar un mensaje al
 * cliente. <br/>
 * Creado el 07-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespuestaDto implements Serializable {

	/**
	 * @see {@link Serializable} class
	 */
	private static final long serialVersionUID = 637601541564024086L;

	/**
	 * Determina que todo el proceso realizado ha finalizado con éxito.<br/>
	 * <br/>
	 * - <b>true</b>: Todo el proceso ha finalizado con éxito. <br/>
	 * - <b>false</b>: No se pudo el proceso sea por validaciones o errores internos
	 * del programa.
	 */
	private boolean exitoso;

	/**
	 * Mensaje opcional a enviar al cliente.
	 */
	private String mensaje;

	/**
	 * Propiedad en la cual se le enviaran los datos adicionales al cliente.
	 */
	private Object data;

	/**
	 * Contructor por defecto, inicializa {@link #exitoso} en <b>true</b>.
	 */
	public RespuestaDto() {
		this.exitoso = true;
		this.mensaje = null;
		this.data = null;
	}

	/**
	 * Contructor para inicializar con valor la propiedad {@link #exitoso}.
	 * 
	 * @param exitoso Valor a asignar a la propiedad {@link #exitoso}.
	 */
	public RespuestaDto(boolean exitoso) {
		this.exitoso = exitoso;
		this.mensaje = null;
		this.data = null;
	}

	/**
	 * Contructor para inicializar con valor la propiedad {@link #exitoso}.
	 * 
	 * @param exitoso Valor a asignar a la propiedad {@link #exitoso}.
	 * @param mensaje Valor a asignar a la propiedad {@link #mensaje}.
	 * 
	 */
	public RespuestaDto(boolean exitoso, String mensaje) {
		this.exitoso = exitoso;
		this.mensaje = mensaje;
		this.data = null;
	}

	/**
	 * Contructor para inicializar con valor las propiedades {@link #exitoso},
	 * {@link #mensaje}, {@link #data}.
	 * 
	 * @param exitoso Valor a asignar a la propiedad {@link #exitoso}.
	 * @param mensaje Valor a asignar a la propiedad {@link #mensaje}.
	 * @param data    Valor a asignar a la propiedad {@link #data}.
	 */
	public RespuestaDto(boolean exitoso, String mensaje, Object data) {
		this.exitoso = exitoso;
		this.mensaje = mensaje;
		this.data = data;
	}

	/**
	 * Retorna el valor de la propiedad {@link #exitoso}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @return {@link boolean}, con el valor de la propiedad {@link #exitoso}.</b>
	 */
	public boolean isExitoso() {
		return exitoso;
	}

	/**
	 * Asigna un valor a la propiedad {@link #exitoso}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @param exitoso Un valor de tipo {@link boolean} a asignar a la propiedad
	 *                {@link #exitoso}.
	 */
	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}

	/**
	 * Retorna el valor de la propiedad {@link #mensaje}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @return {@link String}, con el valor de la propiedad {@link #mensaje}.</b>
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Asigna un valor a la propiedad {@link #mensaje}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @param mensaje Un valor de tipo {@link String} a asignar a la propiedad
	 *                {@link #mensaje}.
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Retorna el valor de la propiedad {@link #data}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @return {@link Object}, con el valor de la propiedad {@link #data}.</b>
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Asigna un valor a la propiedad {@link #data}.<br/>
	 * <br/>
	 * Creado el 07-08-2021.
	 *
	 * @param data Un valor de tipo {@link Object} a asignar a la propiedad
	 *             {@link #data}.
	 */
	public void setData(Object data) {
		this.data = data;
	}

}
