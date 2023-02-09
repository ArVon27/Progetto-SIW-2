package it.uniroma3.SW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class SWApplication {

	public static void main(String[] args) {
		SpringApplication.run(SWApplication.class, args);
	}

} 