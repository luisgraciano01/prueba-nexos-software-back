package co.com.nexossoftware.pruebatecnica.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import co.com.nexossoftware.pruebatecnica.controller.impl.MercanciaControllerImpl;
import co.com.nexossoftware.pruebatecnica.dto.MercanciaOutDto;
import co.com.nexossoftware.pruebatecnica.dto.UsuarioOutDto;
import co.com.nexossoftware.pruebatecnica.service.MercanciaService;

@RunWith(SpringRunner.class)
@WebMvcTest(MercanciaControllerImpl.class)
@AutoConfigureWebMvc
@AutoConfigureMockMvc
public class MercanciaControllerImplTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MercanciaService mercanciaService;

	@Test
	@DisplayName("Consumir /mercancia/findByMultipleCriteria exitoso sin datos.")
	public void findByMultipleCriteria_sucess_without_data() throws Exception {
		List<MercanciaOutDto> mockList = new ArrayList<>();

		Mockito.when(mercanciaService.findByMultipleCriteria(null, 1, null)).thenReturn(mockList);

		mockMvc.perform(MockMvcRequestBuilders
				.get("/mercancia/findByMultipleCriteria?idUsuarioRegistra=1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.exitoso", is(true)))
				.andExpect(jsonPath("$.data", hasSize(0)));
	}

	@Test
	@DisplayName("Consumir /mercancia/findByMultipleCriteria exitoso con datos.")
	public void findByMultipleCriteria_sucess_with_data() throws Exception {
		final Date currentDate = new Date();

		List<MercanciaOutDto> mockList = new ArrayList<>();
		MercanciaOutDto m1 = new MercanciaOutDto();
		m1.setIdMercancia(1);
		m1.setNombreProducto("Producto 1");
		m1.setCantidad(30);
		m1.setFechaIngreso(currentDate);
		m1.setFechaRegistro(currentDate);
		m1.setUsuarioRegistra(new UsuarioOutDto());
		m1.getUsuarioRegistra().setIdUsuario(1);
		m1.getUsuarioRegistra().setNombre("Luis Graciano");
		mockList.add(m1);

		Mockito.when(mercanciaService.findByMultipleCriteria(null, 1, null)).thenReturn(mockList);

		mockMvc.perform(MockMvcRequestBuilders
				.get("/mercancia/findByMultipleCriteria?idUsuarioRegistra=1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.exitoso", is(true)))
				.andExpect(jsonPath("$.data", hasSize(1)))
				.andExpect(jsonPath("$.data[0].idMercancia", is(1)))
				.andExpect(jsonPath("$.data[0].nombreProducto", is("Producto 1")))
				.andExpect(jsonPath("$.data[0].cantidad", is(30)))
				.andExpect(jsonPath("$.data[0].usuarioRegistra.idUsuario", is(1)))
				.andExpect(jsonPath("$.data[0].usuarioRegistra.nombre", is("Luis Graciano")));
	}

}
