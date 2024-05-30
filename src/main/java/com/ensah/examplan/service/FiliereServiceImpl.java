package com.ensah.examplan.service;

import com.ensah.examplan.exception.ResourceNotFoundException;
import com.ensah.examplan.model.Filiere;
import com.ensah.examplan.repository.FiliereRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereServiceImpl implements  FiliereService{
    @Autowired
    FiliereRepsitory filiereRepsitory;
    @Override
    public List<Filiere> getAllFilieres() {
        return filiereRepsitory.findAll();
    }

    @Override
    public Filiere getFiliereById(Long idFiliere) {
        return filiereRepsitory.findById(idFiliere).orElseThrow(() -> new ResourceNotFoundException("le filiere avec cet id n'existe pas" +idFiliere ));
    }
}
