package com.ensah.examplan.repository;

import com.ensah.examplan.model.Enseignant;
import com.ensah.examplan.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExamenRepository extends JpaRepository<Examen, Long> {
}
