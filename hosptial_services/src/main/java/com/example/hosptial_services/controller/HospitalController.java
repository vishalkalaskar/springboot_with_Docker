package com.example.hosptial_services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/patients")
    public String getPatients() {
        // If not using docker-compose, use host.docker.internal
        return restTemplate.getForObject("http://host.docker.internal:8081/api/patients", String.class);
    }

    @GetMapping("/doctors")
    public String getDoctors() {
        return restTemplate.getForObject("http://host.docker.internal:8082/api/doctors", String.class);
    }
}
