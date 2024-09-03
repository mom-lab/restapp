package br.marcelo.web.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestappApplication.class, args);
	}

}
