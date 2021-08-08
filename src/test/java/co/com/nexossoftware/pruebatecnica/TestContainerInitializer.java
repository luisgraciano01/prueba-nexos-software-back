package co.com.nexossoftware.pruebatecnica;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startables;

/**
 * Clase que implementa {@link ApplicationContextInitializer} para la
 * configuración e inicialización de un contenedor de Docker limpio con
 * PosgreSQL {@link PostgreSQLContainer} para ejecutar pruebas sobre el.<br/>
 * <br/>
 * Creado el 07-08-2021
 *
 * @author Luis Alberto Graciano Padierna
 * @since 1.0.0
 */
public class TestContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:10.17-alpine3.13")
			.withReuse(false)
			.withDatabaseName("nexos_software")
			.withUsername("nexos_software")
			.withPassword("n3x0s_s0ftw4r3");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextInitializer#initialize(org.
	 * springframework.context.ConfigurableApplicationContext)
	 */
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		Startables.deepStart(Stream.of(postgres)).join();

		ConfigurableEnvironment environment = applicationContext.getEnvironment();

		Map<String, Object> configuration = new HashMap<>();
		configuration.put("spring.datasource.url", postgres.getJdbcUrl());
		configuration.put("spring.datasource.username", postgres.getUsername());
		configuration.put("spring.datasource.password", postgres.getPassword());

		MapPropertySource testcontainers = new MapPropertySource("testcontainers", configuration);

		environment.getPropertySources().addFirst(testcontainers);
	}

}
