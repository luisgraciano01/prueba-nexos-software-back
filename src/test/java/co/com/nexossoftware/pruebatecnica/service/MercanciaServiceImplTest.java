package co.com.nexossoftware.pruebatecnica.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.nexossoftware.pruebatecnica.dto.EditarMercanciaInDto;
import co.com.nexossoftware.pruebatecnica.dto.MercanciaOutDto;
import co.com.nexossoftware.pruebatecnica.dto.RegistrarMercanciaInDto;
import co.com.nexossoftware.pruebatecnica.dto.UsuarioOutDto;
import co.com.nexossoftware.pruebatecnica.entity.MercanciaEntity;
import co.com.nexossoftware.pruebatecnica.entity.UsuarioEntity;
import co.com.nexossoftware.pruebatecnica.repository.MercanciaRepository;
import co.com.nexossoftware.pruebatecnica.service.impl.MercanciaServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MercanciaService.class, MercanciaServiceImpl.class, MercanciaRepository.class })
public class MercanciaServiceImplTest {

	@Autowired
	private MercanciaService mercanciaService;

	@MockBean
	private MercanciaRepository mercanciaRepository;

	@Test
	@DisplayName("Consultar mercancía con multiples filtros")
	public void findByMultipleCriteria() {
		final Date currentDate = new Date();

		List<MercanciaEntity> mockList = new ArrayList<MercanciaEntity>();
		MercanciaEntity me1 = new MercanciaEntity();
		me1.setIdMercancia(1);
		me1.setNombreProducto("Producto 1");
		me1.setCantidad(30);
		me1.setFechaIngreso(currentDate);
		me1.setFechaRegistro(currentDate);
		me1.setUsuarioRegistraEntity(new UsuarioEntity());
		me1.getUsuarioRegistraEntity().setIdUsuario(1);
		me1.getUsuarioRegistraEntity().setNombre("Luis Graciano");
		mockList.add(me1);

		Mockito.when(mercanciaRepository.findByMultipleCriteria("Producto 1", null, null)).thenReturn(mockList);

		List<MercanciaOutDto> expectedList = new ArrayList<>();
		MercanciaOutDto m1 = new MercanciaOutDto();
		m1.setIdMercancia(1);
		m1.setNombreProducto("Producto 1");
		m1.setCantidad(30);
		m1.setFechaIngreso(currentDate);
		m1.setFechaRegistro(currentDate);
		m1.setUsuarioRegistra(new UsuarioOutDto());
		m1.getUsuarioRegistra().setIdUsuario(1);
		m1.getUsuarioRegistra().setNombre("Luis Graciano");
		expectedList.add(m1);

		List<MercanciaOutDto> resultList = mercanciaService.findByMultipleCriteria("Producto 1", null, null);

		assertEquals(expectedList.size(), resultList.size());
		assertEquals(expectedList.get(0).getCantidad(), resultList.get(0).getCantidad());
		assertEquals(expectedList.get(0).getIdMercancia(), resultList.get(0).getIdMercancia());
		assertEquals(expectedList.get(0).getFechaIngreso(), resultList.get(0).getFechaIngreso());
		assertEquals(expectedList.get(0).getFechaRegistro(), resultList.get(0).getFechaRegistro());
		assertEquals(expectedList.get(0).getNombreProducto(), resultList.get(0).getNombreProducto());
		assertEquals(expectedList.get(0).getUsuarioRegistra().getIdUsuario(), resultList.get(0).getUsuarioRegistra().getIdUsuario());
		assertEquals(expectedList.get(0).getUsuarioRegistra().getNombre(), resultList.get(0).getUsuarioRegistra().getNombre());
	}

	@Test
	@DisplayName("Verificar si existe mercancía verdadero")
	public void existeMercancia_true() {
		final Date currentDate = new Date();

		MercanciaEntity me1 = new MercanciaEntity();
		me1.setIdMercancia(1);
		me1.setNombreProducto("Producto 1");
		me1.setCantidad(30);
		me1.setFechaIngreso(currentDate);
		me1.setFechaRegistro(currentDate);
		me1.setUsuarioRegistraEntity(new UsuarioEntity());
		me1.getUsuarioRegistraEntity().setIdUsuario(1);
		me1.getUsuarioRegistraEntity().setNombre("Luis Graciano");

		Mockito.when(mercanciaRepository.findByNombreProducto("Producto 1")).thenReturn(Optional.of(me1));

		assertTrue(mercanciaService.existeMercancia("Producto 1"));
	}

	@Test
	@DisplayName("Verificar si existe mercancía false")
	public void existeMercancia_false() {
		Mockito.when(mercanciaRepository.findByNombreProducto("Producto 1")).thenReturn(Optional.empty());

		assertFalse(mercanciaService.existeMercancia("Producto 1"));
	}

	@Test
	@DisplayName("Guardar cuando existe mercancía")
	public void save_existe_mercancia() {
		final Date currentDate = new Date();

		MercanciaEntity mercanciaEntity = new MercanciaEntity();
		mercanciaEntity.setIdMercancia(1);
		mercanciaEntity.setNombreProducto("Producto 1");
		mercanciaEntity.setCantidad(30);
		mercanciaEntity.setFechaIngreso(currentDate);
		mercanciaEntity.setFechaRegistro(currentDate);
		mercanciaEntity.setUsuarioRegistraEntity(new UsuarioEntity());
		mercanciaEntity.getUsuarioRegistraEntity().setIdUsuario(1);
		mercanciaEntity.getUsuarioRegistraEntity().setNombre("Luis Graciano");

		RegistrarMercanciaInDto registrarMercanciaInDto = new RegistrarMercanciaInDto();
		registrarMercanciaInDto.setNombreProducto("Producto 1");
		registrarMercanciaInDto.setCantidad(30);
		registrarMercanciaInDto.setFechaIngreso(currentDate);
		registrarMercanciaInDto.setIdUsuarioRegistra(1);

		Mockito.when(mercanciaRepository.findByNombreProducto("Producto 1")).thenReturn(Optional.of(mercanciaEntity));

		Mockito.when(mercanciaRepository.save(mercanciaEntity)).thenReturn(mercanciaEntity);

		assertFalse(mercanciaService.save(registrarMercanciaInDto));
	}

	@Test
	@DisplayName("Guardar cuando no existe mercancía")
	public void save_no_existe_mercancia() {
		final Date currentDate = new Date();

		MercanciaEntity mercanciaEntity = new MercanciaEntity();
		mercanciaEntity.setIdMercancia(1);
		mercanciaEntity.setNombreProducto("Producto 1");
		mercanciaEntity.setCantidad(30);
		mercanciaEntity.setFechaIngreso(currentDate);
		mercanciaEntity.setFechaRegistro(currentDate);
		mercanciaEntity.setUsuarioRegistraEntity(new UsuarioEntity());
		mercanciaEntity.getUsuarioRegistraEntity().setIdUsuario(1);
		mercanciaEntity.getUsuarioRegistraEntity().setNombre("Luis Graciano");

		RegistrarMercanciaInDto registrarMercanciaInDto = new RegistrarMercanciaInDto();
		registrarMercanciaInDto.setNombreProducto("Producto 1");
		registrarMercanciaInDto.setCantidad(30);
		registrarMercanciaInDto.setFechaIngreso(currentDate);
		registrarMercanciaInDto.setIdUsuarioRegistra(1);

		Mockito.when(mercanciaRepository.findByNombreProducto("Producto 1")).thenReturn(Optional.empty());

		Mockito.when(mercanciaRepository.save(mercanciaEntity)).thenReturn(mercanciaEntity);

		assertTrue(mercanciaService.save(registrarMercanciaInDto));
	}

	@Test
	@DisplayName("Consultar por id cuando existe mercancía")
	public void findById_existe() {
		final Date currentDate = new Date();

		MercanciaEntity mockEntity = new MercanciaEntity();
		mockEntity.setIdMercancia(1);
		mockEntity.setNombreProducto("Producto 1");
		mockEntity.setCantidad(30);
		mockEntity.setFechaIngreso(currentDate);
		mockEntity.setFechaRegistro(currentDate);
		mockEntity.setUsuarioRegistraEntity(new UsuarioEntity());
		mockEntity.getUsuarioRegistraEntity().setIdUsuario(1);
		mockEntity.getUsuarioRegistraEntity().setNombre("Luis Graciano");

		MercanciaOutDto expected = new MercanciaOutDto();
		expected.setIdMercancia(1);
		expected.setNombreProducto("Producto 1");
		expected.setCantidad(30);
		expected.setFechaIngreso(currentDate);
		expected.setFechaRegistro(currentDate);
		expected.setUsuarioRegistra(new UsuarioOutDto());
		expected.getUsuarioRegistra().setIdUsuario(1);
		expected.getUsuarioRegistra().setNombre("Luis Graciano");

		Mockito.when(mercanciaRepository.findById(1)).thenReturn(Optional.of(mockEntity));

		MercanciaOutDto result = mercanciaService.findById(1);

		assertNotNull(result);
		assertEquals(expected.getCantidad(), result.getCantidad());
		assertEquals(expected.getIdMercancia(), result.getIdMercancia());
		assertEquals(expected.getFechaIngreso(), result.getFechaIngreso());
		assertEquals(expected.getFechaRegistro(), result.getFechaRegistro());
		assertEquals(expected.getNombreProducto(), result.getNombreProducto());
		assertEquals(expected.getUsuarioRegistra().getIdUsuario(), result.getUsuarioRegistra().getIdUsuario());
		assertEquals(expected.getUsuarioRegistra().getNombre(), result.getUsuarioRegistra().getNombre());
	}

	@Test
	@DisplayName("Consultar por id cuando no existe mercancía")
	public void findById_no_existe() {
		Mockito.when(mercanciaRepository.findById(1)).thenReturn(Optional.empty());

		MercanciaOutDto result = mercanciaService.findById(1);

		assertNull(result);
	}

	@Test
	@DisplayName("Actualizar cuando no existe mercancía")
	public void update_no_existe_mercancia() {
		final Date currentDate = new Date();

		MercanciaEntity mercanciaEntity = new MercanciaEntity();
		mercanciaEntity.setIdMercancia(1);
		mercanciaEntity.setNombreProducto("Producto 1");
		mercanciaEntity.setCantidad(30);
		mercanciaEntity.setFechaIngreso(currentDate);
		mercanciaEntity.setFechaRegistro(currentDate);
		mercanciaEntity.setUsuarioRegistraEntity(new UsuarioEntity());
		mercanciaEntity.getUsuarioRegistraEntity().setIdUsuario(1);
		mercanciaEntity.getUsuarioRegistraEntity().setNombre("Luis Graciano");

		EditarMercanciaInDto editarMercanciaInDto = new EditarMercanciaInDto();
		editarMercanciaInDto.setIdMercancia(1);
		editarMercanciaInDto.setIdUsuarioActualiza(1);
		editarMercanciaInDto.setNombreProducto("Producto 1");
		editarMercanciaInDto.setCantidad(30);
		editarMercanciaInDto.setFechaIngreso(currentDate);

		Mockito.when(mercanciaRepository.findById(1)).thenReturn(Optional.empty());

		Mockito.when(mercanciaRepository.save(mercanciaEntity)).thenReturn(mercanciaEntity);

		assertFalse(mercanciaService.update(editarMercanciaInDto));
	}

	@Test
	@DisplayName("Actualizar cuando existe mercancía")
	public void update_existe_mercancia() {
		final Date currentDate = new Date();

		MercanciaEntity mercanciaEntity = new MercanciaEntity();
		mercanciaEntity.setIdMercancia(1);
		mercanciaEntity.setNombreProducto("Producto 1");
		mercanciaEntity.setCantidad(30);
		mercanciaEntity.setFechaIngreso(currentDate);
		mercanciaEntity.setFechaRegistro(currentDate);
		mercanciaEntity.setUsuarioRegistraEntity(new UsuarioEntity());
		mercanciaEntity.getUsuarioRegistraEntity().setIdUsuario(1);
		mercanciaEntity.getUsuarioRegistraEntity().setNombre("Luis Graciano");

		EditarMercanciaInDto editarMercanciaInDto = new EditarMercanciaInDto();
		editarMercanciaInDto.setIdMercancia(1);
		editarMercanciaInDto.setIdUsuarioActualiza(1);
		editarMercanciaInDto.setNombreProducto("Producto 1");
		editarMercanciaInDto.setCantidad(30);
		editarMercanciaInDto.setFechaIngreso(currentDate);

		Mockito.when(mercanciaRepository.findById(1)).thenReturn(Optional.of(mercanciaEntity));

		Mockito.when(mercanciaRepository.save(mercanciaEntity)).thenReturn(mercanciaEntity);

		assertTrue(mercanciaService.update(editarMercanciaInDto));
	}

	@Test
	@DisplayName("Eliminar mercancía")
	public void delete() {
		Mockito.doNothing().when(mercanciaRepository).deleteById(1);

		assertTrue(mercanciaService.delete(1));
	}

}
