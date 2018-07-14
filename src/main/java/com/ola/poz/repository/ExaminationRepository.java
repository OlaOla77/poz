package com.ola.poz.repository;

import com.ola.poz.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

    Boolean existsByNameIgnoreCase(String name);

    List<Examination> findByNameContainingIgnoreCase(String name);
}
