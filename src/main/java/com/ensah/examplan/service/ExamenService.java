package com.ensah.examplan.service;

import com.ensah.examplan.model.Examen;
import com.ensah.examplan.model.Salle;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface ExamenService {
    Examen addExamen(Examen examen, Set<Salle> salles, MultipartFile epreuveFile, MultipartFile pvFile, Long idGroupe);
    Examen getExamenById(Long idExamen);
    List<Examen> getAllExamens();
    Examen updateExamen(Long idExamen, Examen updatedExamen);
    void deleteExamen(Long idExamen);
    void affecterSurveillants(Long idGroupe,Set<Salle> salles);
}
