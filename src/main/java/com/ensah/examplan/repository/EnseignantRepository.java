package com.ensah.examplan.repository;

import com.ensah.examplan.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    @Query(value = "select * from personnel where email = ?1", nativeQuery = true)
    Optional<Enseignant> findByEmail(String email);
}
