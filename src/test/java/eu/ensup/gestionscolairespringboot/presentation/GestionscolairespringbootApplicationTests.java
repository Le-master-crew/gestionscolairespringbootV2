package eu.ensup.gestionscolairespringboot.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import eu.ensup.gestionscolairespringboot.controller.StaticController;

@SpringBootTest
class GestionscolairespringbootApplicationTests {

	@Autowired
	private StaticController controller;
	
	@Test
	void controllerNotNull() {
		assertThat(controller).isNotNull();
	}
	
}
