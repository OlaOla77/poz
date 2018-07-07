package com.ola.poz.repository;

import com.ola.poz.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

    Boolean existsByNameIgnoreCase(String name);
}
