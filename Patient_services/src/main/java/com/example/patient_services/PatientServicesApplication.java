package com.example.patient_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "Patient Service API",
	        version = "1.0",
	        description = "API documentation for managing patients"
	    )
	)
public class PatientServicesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PatientServicesApplication.class, args);
	}

}
