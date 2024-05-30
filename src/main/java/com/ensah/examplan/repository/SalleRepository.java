package com.ensah.examplan.repository;

import com.ensah.examplan.model.Examen;
import com.ensah.examplan.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle, Long> {

}
