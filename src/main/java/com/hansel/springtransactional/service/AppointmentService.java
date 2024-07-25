package com.hansel.springtransactional.service;

import com.hansel.springtransactional.entity.Appointment;
import com.hansel.springtransactional.entity.Patient;
import com.hansel.springtransactional.model.response.GetAllAppointmentResponse;
import com.hansel.springtransactional.repository.AppointmentRepository;
import com.hansel.springtransactional.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    public List<GetAllAppointmentResponse> getAllAppointmentByPatient(Integer patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        return appointmentRepository.findAllByPatient(patient);
    }

    public List<GetAllAppointmentResponse> getAllAppointmentByPatientId(Integer patientId) {
        return appointmentRepository.findAllByPatientId(patientId);
    }
}
