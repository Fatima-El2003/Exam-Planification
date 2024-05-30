package com.ensah.examplan.service;

import com.ensah.examplan.model.Enseignant;
import java.util.List;

public interface EnseignantService {
    Enseignant addEnseignant(Enseignant enseignant);
    Enseignant getEnseignantById(Long idEnseignant);
    List<Enseignant> getAllEnseignants();
    Enseignant updateEnseignant(Long idEnseignant, Enseignant updatedEnseignant);
    void deleteEnseignant(Long idEnseignant);
    List<Enseignant> getSurveillantsByGroupe(Long idGroupe, Long surveillantCount);
}
