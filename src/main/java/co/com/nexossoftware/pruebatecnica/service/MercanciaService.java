package co.com.nexossoftware.pruebatecnica.service;

import java.util.Date;
import java.util.List;

import co.com.nexossoftware.pruebatecnica.dto.EditarMercanciaInDto;
import co.com.nexossoftware.pruebatecnica.dto.MercanciaOutDto;
import co.com.nexossoftware.pruebatecnica.dto.RegistrarMercanciaInDto;

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

	/**
	 * Determina si existe una mercancía por un nombre producto.
	 * 
	 * @param nombreProducto Nombre del producto.
	 * @return - {@code true} si existe la mercancía.<br/>
	 *         - {@code false} si no existe la mercancía.
	 * 
	 */
	public boolean existeMercancia(String nombreProducto);

	/**
	 * Registra en base de datos una mercancía
	 * 
	 * @param registrarMercanciaInDto Datos de la mercancía a registrar.
	 * @return - {@code true} si registró la mercancía con éxito.<br/>
	 *         - {@code false} si no regitró la mercancía.
	 */
	public boolean save(RegistrarMercanciaInDto registrarMercanciaInDto);

	/**
	 * Busca en la base de datos una mercancía por su identificador.
	 * 
	 * @param idMercancia Identificador de la mercancía.
	 * @return {@link MercanciaOutDto} con los datos de la mercancía encontrada, de
	 *         lo contrario {@code null}.
	 */
	public MercanciaOutDto findById(Integer idMercancia);

	/**
	 * Actualiza en base de datos una mercancía
	 * 
	 * @param editarMercanciaInDto Datos de la mercancía a actualizar.
	 * @return - {@code true} si actualizó la mercancía con éxito.<br/>
	 *         - {@code false} si no actualizó la mercancía.
	 */
	public boolean update(EditarMercanciaInDto editarMercanciaInDto);

	/**
	 * Elimina en base de datos una mercancía
	 * 
	 * @param idMercancia Identificador de la mercancía.
	 * @return - {@code true} si eliminó la mercancía con éxito.<br/>
	 *         - {@code false} si no eliminó la mercancía.
	 */
	public boolean delete(Integer idMercancia);

}
