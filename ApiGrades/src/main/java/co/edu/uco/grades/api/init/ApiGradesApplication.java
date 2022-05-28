package co.edu.uco.grades.api.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.grades"} )
public class ApiGradesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGradesApplication.class, args);
	}

}
