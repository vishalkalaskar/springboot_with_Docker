package com.example.doctor_services.controller;


import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor_services.model.Doctor;
import com.example.doctor_services.services.DoctorService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Operation(summary = "Get all doctors", description = "Fetch all doctor records from the database")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @Operation(summary = "Get doctor by ID", description = "Fetch a doctor record by ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @Operation(summary = "Add new doctor", description = "Insert a new doctor record")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @Operation(summary = "Update doctor", description = "Update existing doctor record by ID")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) {
        return doctorService.updateDoctor(id, doctorDetails);
    }

    @Operation(summary = "Delete doctor", description = "Delete a doctor record by ID")
    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "Doctor deleted with id " + id;
    }
}

