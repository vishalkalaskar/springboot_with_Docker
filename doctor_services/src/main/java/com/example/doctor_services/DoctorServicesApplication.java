package com.example.doctor_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "Doctor Service API",
	        version = "1.0",
	        description = "API documentation for managing patients"
	    )
	)
public class DoctorServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorServicesApplication.class, args);
	}

}
