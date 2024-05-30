package com.ensah.examplan.repository;

import com.ensah.examplan.model.Department;
import com.ensah.examplan.model.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiliereRepsitory extends JpaRepository<Filiere,Long> {
}
