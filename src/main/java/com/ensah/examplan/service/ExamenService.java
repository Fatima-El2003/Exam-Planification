package com.ensah.examplan.service;

import com.ensah.examplan.model.Examen;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExamenService {
    Examen addExamen(Examen examen, MultipartFile epreuveFile, MultipartFile pvFile);
    Examen getExamenById(Long idExamen);
    List<Examen> getAlExamens();
    Examen updateExamen(Long idExamen, Examen updatedExamen);
    void deleteExamen(Long idExamen);
}
