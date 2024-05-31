package com.ensah.examplan.service;

import com.ensah.examplan.model.Enseignant;
<<<<<<< HEAD
=======

import java.time.LocalTime;
>>>>>>> origin/master
import java.util.List;

public interface EnseignantService {
    Enseignant addEnseignant(Enseignant enseignant);
    Enseignant getEnseignantById(Long idEnseignant);
    List<Enseignant> getAllEnseignants();
    Enseignant updateEnseignant(Long idEnseignant, Enseignant updatedEnseignant);
    void deleteEnseignant(Long idEnseignant);
<<<<<<< HEAD
    List<Enseignant> getSurveillantsByGroupe(Long idGroupe, Long surveillantCount);
=======
    List<Enseignant> getSurveillantsByGroupe(Long idGroupe, Long surveillantCount, LocalTime heureDebutExam, LocalTime heureFinExam);
>>>>>>> origin/master
}
