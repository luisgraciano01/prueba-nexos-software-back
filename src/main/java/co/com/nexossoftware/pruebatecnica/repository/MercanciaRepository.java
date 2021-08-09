package co.com.nexossoftware.pruebatecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.nexossoftware.pruebatecnica.entity.MercanciaEntity;

/**
 * Interfaz {@link Repository} genérica para la entidad
 * {@link MercanciaEntity}.<br/>
 * <br/>
 * Creado el 08-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
@Repository("MercanciaRepository")
public interface MercanciaRepository extends JpaRepository<MercanciaEntity, Integer> {

	/**
	 * Busca en la base de datos las mercancías ingresadas por múltiples filtros.
	 * 
	 * @param nombreProducto    Valor filtro nombre producto.
	 * @param idUsuarioRegistra Valor filtro identificador usuario registra.
	 * @param fechaIngreso      Valor filtro fecha de ingreso de la mercancía.
	 * @return {@link List} de {@link MercanciaEntity} con cada uno de los registros
	 *         en encontrados en base de datos.
	 */
	@Query("SELECT m FROM MercanciaEntity m"
			+ " WHERE (:nombreProducto IS NULL OR m.nombreProducto = :nombreProducto)"
			+ " AND (:idUsuarioRegistra IS NULL OR m.idUsuarioRegistra = :idUsuarioRegistra)"
			+ " AND (:fechaIngreso IS NULL OR cast(m.fechaIngreso as date) = TO_DATE(cast(:fechaIngreso as text), 'DD/MM/YYYY'))")
	public List<MercanciaEntity> findByMultipleCriteria(String nombreProducto, Integer idUsuarioRegistra, String fechaIngreso);
}
