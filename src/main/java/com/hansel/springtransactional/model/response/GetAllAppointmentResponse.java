package com.hansel.springtransactional.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hansel.springtransactional.entity.Patient;

import java.time.LocalDate;
import java.time.LocalTime;

public record GetAllAppointmentResponse(
        @JsonProperty("id")
        Long id,

        @JsonProperty("appointment_date")
        LocalDate appointmentDate,

        @JsonProperty("appointment_time")
        LocalTime appointmentTime,

        @JsonProperty("appointment_note")
        String appointmentNote,

        @JsonProperty("patient")
        Patient patient
) {
}
