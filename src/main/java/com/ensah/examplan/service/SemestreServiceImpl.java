package com.ensah.examplan.service;

import com.ensah.examplan.model.Semestre;
import com.ensah.examplan.repository.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemestreServiceImpl implements  SemestreService{
    @Autowired
    SemestreRepository semestreRepository;

    @Override
    public List<Semestre> getAllSemestres() {
        return semestreRepository.findAll();
    }

    @Override
    public Semestre getSemestreById(Long idSemestre) {
        return semestreRepository.findById(idSemestre).get();
    }


}
