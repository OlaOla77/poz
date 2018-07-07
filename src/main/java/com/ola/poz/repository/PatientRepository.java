package com.ola.poz.repository;

import com.ola.poz.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Boolean existsByPesel(Long pesel);

    List<Patient> findBySurnameContainingIgnoreCase(String surname);
//
//    List<Patient> findByPeselContaining(Long pesel);

}
