package com.ensah.examplan.repository;

import com.ensah.examplan.model.Admin;
import com.ensah.examplan.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query(value = "SELECT * FROM personnel WHERE id_salle IS NULL", nativeQuery = true)
    List<Admin> findAdminByIdSalleNull();

}
