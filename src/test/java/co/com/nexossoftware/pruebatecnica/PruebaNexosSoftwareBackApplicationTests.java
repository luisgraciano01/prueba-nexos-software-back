package co.com.nexossoftware.pruebatecnica;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = TestContainerInitializer.class)
class PruebaNexosSoftwareBackApplicationTests {

	@Test
	void contextLoads() {
	}

}
