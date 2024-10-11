package com.eazybytes.example45;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAdminServer
@SpringBootApplication
public class Example45Application {

	public static void main(String[] args) {
		SpringApplication.run(Example45Application.class, args);
	}

}
