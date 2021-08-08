package co.com.nexossoftware.pruebatecnica.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.JDBCConnectionException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.com.nexossoftware.pruebatecnica.controller.impl.UsuarioControllerImpl;
import co.com.nexossoftware.pruebatecnica.dto.UsuarioOutDto;
import co.com.nexossoftware.pruebatecnica.service.UsuarioService;

@RunWith(SpringRunner.class)
@WebMvcTest(UsuarioControllerImpl.class)
@AutoConfigureWebMvc
@AutoConfigureMockMvc
public class UsuarioControllerImplTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UsuarioService usuarioService;

	@Test
	@DisplayName("Consumir /usuario/findAll exitoso con datos.")
	public void findAll_sucess() throws Exception {
		List<UsuarioOutDto> mockList = new ArrayList<>();
		UsuarioOutDto u1 = new UsuarioOutDto();
		u1.setIdUsuario(1);
		u1.setNombre("Luis Graciano");
		mockList.add(u1);

		UsuarioOutDto u2 = new UsuarioOutDto();
		u2.setIdUsuario(2);
		u2.setNombre("Prueba Unitaria");
		mockList.add(u2);

		Mockito.when(usuarioService.findAll()).thenReturn(mockList);

		mockMvc.perform(MockMvcRequestBuilders
				.get("/usuario/findAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.exitoso", is(true)))
				.andExpect(jsonPath("$.data", hasSize(2)))
				.andExpect(jsonPath("$.data[0].idUsuario", is(1)))
				.andExpect(jsonPath("$.data[0].nombre", is("Luis Graciano")))
				.andExpect(jsonPath("$.data[1].idUsuario", is(2)))
				.andExpect(jsonPath("$.data[1].nombre", is("Prueba Unitaria")));
	}

	@Test
	@DisplayName("Consumir /usuario/findAll y no hay conexión a la base de datos.")
	public void findAll_any_error() throws Exception {
		Mockito.when(usuarioService.findAll()).thenThrow(JDBCConnectionException.class);

		mockMvc.perform(MockMvcRequestBuilders
				.get("/usuario/findAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.exitoso", is(false)))
				.andExpect(jsonPath("$.mensaje", is("Ha ocurrido un error durante la consulta de los usuarios.")));
	}

}
