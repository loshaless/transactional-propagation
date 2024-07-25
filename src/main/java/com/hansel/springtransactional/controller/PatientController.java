package com.hansel.springtransactional.controller;

import com.hansel.springtransactional.entity.Patient;
import com.hansel.springtransactional.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/patient")
    public List<Patient> getAllPatient() {
        return patientService.getAllPatient();
    }
}
