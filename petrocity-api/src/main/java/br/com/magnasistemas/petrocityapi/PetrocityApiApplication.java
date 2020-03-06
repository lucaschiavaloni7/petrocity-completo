package br.com.magnasistemas.petrocityapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PetrocityApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetrocityApiApplication.class, args);
	}

}
