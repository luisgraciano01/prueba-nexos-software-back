package co.com.nexossoftware.pruebatecnica.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.nexossoftware.pruebatecnica.TestContainerInitializer;
import co.com.nexossoftware.pruebatecnica.entity.MercanciaEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(initializers = TestContainerInitializer.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MercanciaRepositoryTest {

	@Autowired
	private MercanciaRepository mercanciaRepository;

	@Test
	@DisplayName("Consulta mercancía solo por usuario")
	public void findByMultipleCriteria_only_usuario() {
		List<MercanciaEntity> resultList1 = mercanciaRepository.findByMultipleCriteria(null, 1, null);
		List<MercanciaEntity> resultList2 = mercanciaRepository.findByMultipleCriteria(null, 2, null);
		List<MercanciaEntity> resultList3 = mercanciaRepository.findByMultipleCriteria(null, 4, null);

		assertEquals(2, resultList1.size());
		assertEquals(1, resultList2.size());
		assertEquals(0, resultList3.size());
	}

	@Test
	@DisplayName("Consulta mercancía solo por nombre producto")
	public void findByMultipleCriteria_only_nombre_producto() {
		List<MercanciaEntity> resultList1 = mercanciaRepository.findByMultipleCriteria("Producto 1", null, null);
		List<MercanciaEntity> resultList2 = mercanciaRepository.findByMultipleCriteria("Producto 2", null, null);
		List<MercanciaEntity> resultList3 = mercanciaRepository.findByMultipleCriteria("Producto TEST", null, null);

		assertEquals(1, resultList1.size());
		assertEquals(1, resultList2.size());
		assertEquals(0, resultList3.size());
	}

	@Test
	@DisplayName("Consulta mercancía solo por fecha ingreso")
	public void findByMultipleCriteria_only_fecha() {
		List<MercanciaEntity> resultList1 = mercanciaRepository.findByMultipleCriteria(null, null, "01/08/2020");
		List<MercanciaEntity> resultList2 = mercanciaRepository.findByMultipleCriteria(null, null, "02/08/2020");
		List<MercanciaEntity> resultList3 = mercanciaRepository.findByMultipleCriteria(null, null, "03/08/2020");

		assertEquals(3, resultList1.size());
		assertEquals(1, resultList2.size());
		assertEquals(0, resultList3.size());
	}

	@Test
	@DisplayName("Consulta mercancía solo por usuario y fecha ingreso")
	public void findByMultipleCriteria_only_usuario_fecha() {
		List<MercanciaEntity> resultList1 = mercanciaRepository.findByMultipleCriteria(null, 1, "01/08/2020");
		List<MercanciaEntity> resultList2 = mercanciaRepository.findByMultipleCriteria(null, 1, "02/08/2020");
		List<MercanciaEntity> resultList3 = mercanciaRepository.findByMultipleCriteria(null, 4, "01/08/2020");

		assertEquals(1, resultList1.size());
		assertEquals(1, resultList2.size());
		assertEquals(0, resultList3.size());
	}

	@Test
	@DisplayName("Consulta mercancía solo por nombre producto y fecha ingreso")
	public void findByMultipleCriteria_only_nombre_producto_fecha() {
		List<MercanciaEntity> resultList1 = mercanciaRepository.findByMultipleCriteria("Producto 1", null, "01/08/2020");
		List<MercanciaEntity> resultList2 = mercanciaRepository.findByMultipleCriteria("Producto 1", null, "02/08/2020");

		assertEquals(1, resultList1.size());
		assertEquals(0, resultList2.size());
	}

	@Test
	@DisplayName("Consulta mercancía por todos los filtros")
	public void findByMultipleCriteria_all() {
		List<MercanciaEntity> resultList1 = mercanciaRepository.findByMultipleCriteria("Producto 1", 1, "01/08/2020");
		List<MercanciaEntity> resultList2 = mercanciaRepository.findByMultipleCriteria("Producto 1", 2, "01/08/2020");

		assertEquals(1, resultList1.size());
		assertEquals(0, resultList2.size());
	}

}
