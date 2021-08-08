package co.com.nexossoftware.pruebatecnica.service;

import java.util.List;

import co.com.nexossoftware.pruebatecnica.dto.UsuarioOutDto;

/**
 * Interfaz service que determina los métodos de lógica de negocio relacionada a
 * los usuarios. <br/>
 * Creado el 07-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public interface UsuarioService {

	/**
	 * Busca en la base de datos todos los usuarios registrados.
	 * 
	 * @return Una lista de {@link UsuarioOutDto}.
	 */
	public List<UsuarioOutDto> findAll();
}
