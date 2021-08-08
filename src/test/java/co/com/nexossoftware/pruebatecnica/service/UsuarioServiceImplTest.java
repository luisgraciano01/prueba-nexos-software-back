package co.com.nexossoftware.pruebatecnica.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.nexossoftware.pruebatecnica.dto.UsuarioOutDto;
import co.com.nexossoftware.pruebatecnica.entity.UsuarioEntity;
import co.com.nexossoftware.pruebatecnica.repository.UsuarioRepository;
import co.com.nexossoftware.pruebatecnica.service.impl.UsuarioServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { UsuarioService.class, UsuarioServiceImpl.class, UsuarioRepository.class })
public class UsuarioServiceImplTest {

	@Autowired
	private UsuarioService usuarioService;

	@MockBean
	private UsuarioRepository usuarioRepository;

	@Test
	@DisplayName("Consulta la lista de usuarios sin registros")
	public void findAll_empty() {
		Mockito.when(usuarioRepository.findAll()).thenReturn(new ArrayList<>());

		List<UsuarioOutDto> resultList = usuarioService.findAll();
		assertEquals(resultList.size(), 0);
	}

	@Test
	@DisplayName("Consulta la lista de usuarios con 2 registros")
	public void findAll_with_data() {
		List<UsuarioEntity> mockList = new ArrayList<>();
		UsuarioEntity ue1 = new UsuarioEntity();
		ue1.setIdUsuario(1);
		ue1.setNombre("Luis Graciano");
		ue1.setEdad(19);
		ue1.setIdCargo(1);
		ue1.setFechaIngresoEmpresa(new Date());
		ue1.setFechaRegistro(new Date());
		mockList.add(ue1);

		UsuarioEntity ue2 = new UsuarioEntity();
		ue2.setIdUsuario(2);
		ue2.setNombre("Prueba Unitaria");
		ue2.setEdad(33);
		ue2.setIdCargo(2);
		ue2.setFechaIngresoEmpresa(new Date());
		ue2.setFechaRegistro(new Date());
		mockList.add(ue2);

		Mockito.when(usuarioRepository.findAll()).thenReturn(mockList);

		List<UsuarioOutDto> expectedList = new ArrayList<>();
		UsuarioOutDto u1 = new UsuarioOutDto();
		u1.setIdUsuario(1);
		u1.setNombre("Luis Graciano");
		expectedList.add(u1);

		UsuarioOutDto u2 = new UsuarioOutDto();
		u2.setIdUsuario(2);
		u2.setNombre("Prueba Unitaria");
		expectedList.add(u2);

		List<UsuarioOutDto> resultList = usuarioService.findAll();
		assertEquals(resultList.size(), expectedList.size());
	}

}
