package com.ensah.examplan.repository;

import com.ensah.examplan.model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemestreRepository extends JpaRepository <Semestre,Long>{
}
