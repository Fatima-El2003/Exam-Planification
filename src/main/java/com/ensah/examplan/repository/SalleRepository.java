package com.ensah.examplan.repository;

import com.ensah.examplan.model.Examen;
import com.ensah.examplan.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

public interface SalleRepository extends JpaRepository<Salle, Long> {

=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalleRepository extends JpaRepository<Salle, Long> {
    @Query(value = "SELECT s FROM salle s WHERE s.id_examen =  ?1 ", nativeQuery = true)
    List<Salle> findByExamenId( Long examenId);
>>>>>>> origin/master
}
