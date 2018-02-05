package com.airbus.example.delegate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DelegateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelegateApplication.class, args);
	}
}
