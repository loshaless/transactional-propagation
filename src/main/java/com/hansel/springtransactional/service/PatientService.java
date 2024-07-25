package com.hansel.springtransactional.service;

import com.hansel.springtransactional.entity.Patient;
import com.hansel.springtransactional.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    public void editPatient(Integer patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        patient.setPatientName("Hansel");
        patientRepository.save(patient);
    }
}
