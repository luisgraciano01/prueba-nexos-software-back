package co.com.nexossoftware.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.nexossoftware.pruebatecnica.entity.UsuarioEntity;

/**
 * Interfaz {@link Repository} genérica para la entidad
 * {@link UsuarioEntity}.<br/>
 * <br/>
 * Creado el 07-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
@Repository("UsuarioRepository")
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

}
