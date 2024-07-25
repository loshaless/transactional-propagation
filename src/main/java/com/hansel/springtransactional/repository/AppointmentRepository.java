package com.hansel.springtransactional.repository;

import com.hansel.springtransactional.entity.Appointment;
import com.hansel.springtransactional.entity.Patient;
import com.hansel.springtransactional.model.response.GetAllAppointmentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<GetAllAppointmentResponse> findAllByPatient(Patient patient);
    List<GetAllAppointmentResponse> findAllByPatientId(Integer patientId);
}
