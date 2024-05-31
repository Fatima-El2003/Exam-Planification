package com.ensah.examplan.repository;

import com.ensah.examplan.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Department,Long> {

}
