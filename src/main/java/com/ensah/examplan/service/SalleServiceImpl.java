package com.ensah.examplan.service;

import com.ensah.examplan.model.Examen;
import com.ensah.examplan.repository.SalleRepository;
import com.ensah.examplan.model.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImpl implements SalleService{
    @Autowired
    private SalleRepository salleRepository;
    @Override
    public Salle addSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    @Override
    public List<Salle> getSalles() {
        return salleRepository.findAll();
    }
    public List<Salle> getSallesByExamenId(Long examenId) {
        return salleRepository.findByExamenId(examenId);
    }

}
