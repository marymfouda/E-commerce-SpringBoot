package com.example.Alfayomi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.Alfayomi")
@EnableJpaRepositories(basePackages = "com.example.Alfayomi.repository")
public class AlfayomiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlfayomiApplication.class, args);
	}

}
