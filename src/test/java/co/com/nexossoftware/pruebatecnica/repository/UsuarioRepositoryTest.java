package co.com.nexossoftware.pruebatecnica.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import co.com.nexossoftware.pruebatecnica.entity.UsuarioEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(initializers = TestContainerInitializer.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	@DisplayName("Consulta todos los usuarios inicialmente registrados")
	public void find_all_initial_state() {
		List<UsuarioEntity> listaUsuarios = usuarioRepository.findAll();
		assertEquals(listaUsuarios.size(), 3);
	}

	@Test
	@DisplayName("Consulta el usuario con id 1")
	public void find_user_by_id_1() {
		// Fecha ingreso: 01/01/2020 GMT-05:00
		Date fechaIngreso = new Date(1577854800000L);

		Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(1);

		assertThat(usuarioEntity).hasValueSatisfying(usuario -> {
			assertThat(usuario.getIdUsuario()).isNotNull();
			assertThat(usuario.getNombre()).isEqualTo("Luis Graciano");
			assertThat(usuario.getEdad()).isEqualTo(19);
			assertThat(usuario.getIdCargo()).isEqualTo(3);
			assertThat(usuario.getFechaIngresoEmpresa()).isEqualTo(fechaIngreso);
		});
	}

	@Test
	@DisplayName("Guarda un usuario con el id 4")
	public void save_usuario() {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setIdUsuario(4);
		usuarioEntity.setNombre("Prueba Unitaria");
		usuarioEntity.setIdCargo(1);
		usuarioEntity.setEdad(43);
		usuarioEntity.setFechaIngresoEmpresa(new Date());
		usuarioEntity.setFechaRegistro(new Date());

		usuarioRepository.save(usuarioEntity);

		List<UsuarioEntity> listaUsuarios = usuarioRepository.findAll();
		assertEquals(listaUsuarios.size(), 4);
	}

}
