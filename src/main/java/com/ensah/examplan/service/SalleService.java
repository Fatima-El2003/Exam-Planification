package com.ensah.examplan.service;

import com.ensah.examplan.model.Examen;
<<<<<<< HEAD
import com.ensah.examplan.model.Filiere;
=======
>>>>>>> origin/master
import com.ensah.examplan.model.Salle;

import java.util.List;
import java.util.Set;

public interface SalleService {
    Salle addSalle(Salle salle);


    List<Salle> getSalles();
<<<<<<< HEAD
    Salle getSalleById(Long idSalle);
=======
     List<Salle> getSallesByExamenId(Long examenId) ;
>>>>>>> origin/master
}
