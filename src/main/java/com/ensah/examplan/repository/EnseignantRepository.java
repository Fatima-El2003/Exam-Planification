package com.ensah.examplan.repository;

import com.ensah.examplan.model.Enseignant;
import com.ensah.examplan.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    @Query(value = "select * from personnel where email = ?1", nativeQuery = true)
    Optional<Enseignant> findByEmail(String email);

    @Query(value = "SELECT * FROM personnel WHERE groupe_id = :idGroupe AND id_salle IS NULL LIMIT :surveillantCount", nativeQuery = true)
    List<Enseignant> findSurveillantsByGroupe(@Param("idGroupe") Long idGroupe, @Param("surveillantCount") Long surveillantCount);

}
