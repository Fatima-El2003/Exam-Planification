package com.ensah.examplan.service;

import com.ensah.examplan.model.Examen;
import com.ensah.examplan.model.Filiere;
import com.ensah.examplan.model.Salle;

import java.util.List;
import java.util.Set;

public interface SalleService {
    Salle addSalle(Salle salle);


    List<Salle> getSalles();
    Salle getSalleById(Long idSalle);
}
