package com.ensah.examplan.repository;

import com.ensah.examplan.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
}
