package com.eazybytes.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
/*
	iss class ko autoconfigure na kre spring boot ,ye condition evaluation report ke exlusions
	section mai dikhega aur developer kii responsibility hogi iske liye beans aur isko handle karna
	hum aur classes ko bhi exclude krr sakte hai by separting with comma
 */
@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
public class EazySchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazySchoolApplication.class, args);
	}

}
