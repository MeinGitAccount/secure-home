package com.jku.at.securehome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(
	exclude = { SecurityAutoConfiguration.class, ReactiveSecurityAutoConfiguration.class }
)
public class SecureHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureHomeApplication.class, args);
	}

}
