package com.ensah.examplan.service;

import com.ensah.examplan.model.Semestre;

import java.util.List;

public interface SemestreService {
    List<Semestre> getAllSemestres();

    Semestre getSemestreById(Long idSemestre);
}
