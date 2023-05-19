package com.jku.at.securehome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//exclude = { SecurityAutoConfiguration.class, ReactiveSecurityAutoConfiguration.class }
@SpringBootApplication
public class SecureHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureHomeApplication.class, args);
	}

}
