package com.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.eazyschool.proxy")
public class EazySchoolApp {

	public static void main(String[] args) {
		SpringApplication.run(EazySchoolApp.class, args);
	}

}