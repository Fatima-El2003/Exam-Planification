
package com.ensah.examplan.service;

import com.ensah.examplan.model.Department;
import com.ensah.examplan.model.Filiere;

import java.util.List;

public interface FiliereService {
    List<Filiere> getAllFilieres();
    Filiere getFiliereById(Long idFiliere);
}
