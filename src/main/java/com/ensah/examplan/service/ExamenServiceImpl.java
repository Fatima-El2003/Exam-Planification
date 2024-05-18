package com.ensah.examplan.service;

import com.ensah.examplan.model.Examen;
import com.ensah.examplan.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExamenServiceImpl implements ExamenService{
    @Autowired
    private ExamenRepository examenRepository;
    @Override
    public Examen addExamen(Examen examen, MultipartFile epreuveFile, MultipartFile pvFile) {
        try {
            if (epreuveFile != null && !epreuveFile.isEmpty()) {
                examen.setEpreuve(epreuveFile.getBytes());
            }
            if (pvFile != null && !pvFile.isEmpty()) {
                examen.setPv(pvFile.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to store file data", e);
        }
        return examenRepository.save(examen);
    }

    @Override
    public Examen getExamenById(Long idExamen) {
        return null;
    }

    @Override
    public List<Examen> getAlExamens() {
        return null;
    }

    @Override
    public Examen updateExamen(Long idExamen, Examen updatedExamen) {
        return null;
    }

    @Override
    public void deleteExamen(Long idExamen) {

    }
}
