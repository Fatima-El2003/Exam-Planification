package com.ensah.examplan.repository;

import com.ensah.examplan.model.Enseignant;
import com.ensah.examplan.model.Examen;
import com.ensah.examplan.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ExamenRepository extends JpaRepository<Examen, Long> {

}
