package eu.ensup.gestionscolairespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import eu.ensup.gestionscolairespringboot.controller.StaticController;

//@EntityScan("eu.ensup.gestionscolairespringboot.domaine")
//@ComponentScan(basePackageClasses = "eu.ensup.gestionscolairespringboot.controller")
@SpringBootApplication
public class GestionscolairespringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionscolairespringbootApplication.class, args);


	}

}
