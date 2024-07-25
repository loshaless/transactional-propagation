package com.hansel.springtransactional.controller;

import com.hansel.springtransactional.entity.Appointment;
import com.hansel.springtransactional.entity.Patient;
import com.hansel.springtransactional.model.response.GetAllAppointmentResponse;
import com.hansel.springtransactional.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/appointment")
    public List<Appointment> getAllAppointment() {
        return appointmentService.getAllAppointment();
    }

    @GetMapping("/appointment/{patientId}")
    public List<GetAllAppointmentResponse> getAllAppointmentByPatientId(
            @PathVariable Integer patientId
    ) {
        return appointmentService.getAllAppointmentByPatientId(patientId);
    }
}
