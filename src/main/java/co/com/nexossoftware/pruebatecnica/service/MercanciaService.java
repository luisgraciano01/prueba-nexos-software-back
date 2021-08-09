package co.com.nexossoftware.pruebatecnica.service;

import java.util.Date;
import java.util.List;

import co.com.nexossoftware.pruebatecnica.dto.MercanciaOutDto;

/**
 * Interfaz service que determina los métodos de lógica de negocio relacionada a
 * las mercancías. <br/>
 * Creado el 08-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public interface MercanciaService {

	/**
	 * Busca en la base de datos las mercancías ingresadas.
	 * 
	 * @param nombreProducto    Nombre del producto.
	 * @param idUsuarioRegistra Identificador del usuario que registró la mercancía.
	 * @param fechaIngreso      Fecha de ingreso de la mercancía.
	 * @return {@link List} de {@link MercanciaOutDto} con los datos de cada una de
	 *         las mercancías encontradas.
	 */
	public List<MercanciaOutDto> findByMultipleCriteria(String nombreProducto, Integer idUsuarioRegistra, Date fechaIngreso);
}
