package com.ensah.examplan.repository;

import com.ensah.examplan.model.Admin;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
=======
import com.ensah.examplan.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
   // @Query(value = "SELECT * FROM personnel WHERE type = 'Admin' AND id_salle IS NULL", nativeQuery = true)
   @Query(value = "SELECT personnel.*, creneaux.heure_debut_dispo as creneaux_heure_debut_dispo, " +
           "creneaux.heure_fin_dispo as creneaux_heure_fin_dispo " +
           "FROM personnel " +
           "JOIN creneaux ON personnel.id_personnel = creneaux.id_personnel " +
           "WHERE personnel.type = 'Admin' " +
           "AND personnel.id_salle IS NULL " +
           "AND creneaux.heure_debut_dispo = :heureDebutExam " +
           "AND creneaux.heure_fin_dispo = :heureFinExam " +
           "LIMIT 1", nativeQuery = true)
    Admin findAdminByIdSalleNull(@Param("heureDebutExam") LocalTime heureDebutExam, @Param("heureFinExam") LocalTime heureFinExam);

>>>>>>> origin/master
}
