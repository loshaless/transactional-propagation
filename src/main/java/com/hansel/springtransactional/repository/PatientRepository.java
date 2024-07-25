package com.hansel.springtransactional.repository;

import com.hansel.springtransactional.entity.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    /* to mitigate n+1 problem when query findAll */
    @EntityGraph(attributePaths = "appointments")
    List<Patient> findAll();
}
