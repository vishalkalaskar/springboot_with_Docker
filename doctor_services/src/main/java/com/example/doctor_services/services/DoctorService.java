package com.example.doctor_services.services;


import com.example.doctor_services.model.Doctor;
import com.example.doctor_services.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctor.setName(doctorDetails.getName());
                    doctor.setSpecialization(doctorDetails.getSpecialization());
                    doctor.setPhone(doctorDetails.getPhone());
                    doctor.setEmail(doctorDetails.getEmail());
                    return doctorRepository.save(doctor);
                }).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}

