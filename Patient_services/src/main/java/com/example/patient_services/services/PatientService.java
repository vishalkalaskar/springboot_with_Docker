package com.example.patient_services.services;


import com.example.patient_services.model.Patient;
import com.example.patient_services.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patientDetails) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setName(patientDetails.getName());
                    patient.setAge(patientDetails.getAge());
                    patient.setGender(patientDetails.getGender());
                    patient.setAddress(patientDetails.getAddress());
                    return patientRepository.save(patient);
                }).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
