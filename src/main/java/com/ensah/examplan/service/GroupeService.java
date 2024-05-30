package com.ensah.examplan.service;

import com.ensah.examplan.model.Filiere;
import com.ensah.examplan.model.Groupe;

import java.util.List;

public interface GroupeService {
    List<Groupe> getAllGroupes();
    Groupe getGroupeById(Long idGroupe);
}
