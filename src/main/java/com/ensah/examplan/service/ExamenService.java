package com.ensah.examplan.service;

import com.ensah.examplan.model.Examen;

import java.util.List;

public interface ExamenService {
    Examen addExamen(Examen examen);
    Examen getExamenById(Long idExamen);
    List<Examen> getAlExamens();
    Examen updateExamen(Long idExamen, Examen updatedExamen);
    void deleteExamen(Long idExamen);
}
