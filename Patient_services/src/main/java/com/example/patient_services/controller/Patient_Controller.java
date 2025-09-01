package com.example.patient_services.controller;


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

import com.example.patient_services.model.Patient;
import com.example.patient_services.services.PatientService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/patients")
public class Patient_Controller {

    private final PatientService patientService;

    public Patient_Controller(PatientService patientService) {
        this.patientService = patientService;
    }

    @Operation(summary = "Get all patients", description = "Fetches a list of all patients from the database")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @Operation(summary = "Get patient by ID", description = "Fetch a single patient by its ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @Operation(summary = "Add new patient", description = "Create a new patient record")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @Operation(summary = "Update patient", description = "Update an existing patient record by ID")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        return patientService.updatePatient(id, patientDetails);
    }

    @Operation(summary = "Delete patient", description = "Delete a patient record by ID")
    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "Patient deleted with id " + id;
    }
}

