package com.ensah.examplan.service;

import com.ensah.examplan.model.Examen;
import com.ensah.examplan.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServiceImpl implements ExamenService{
    @Autowired
    private ExamenRepository examenRepository;
    @Override
    public Examen addExamen(Examen examen) {
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
