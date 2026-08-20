package com.Haritpane.springBoot_haritpane_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBootHaritpaneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHaritpaneBackendApplication.class, args);
	}

}
