package com.ensah.examplan.service;

import com.ensah.examplan.model.Personnel;

import java.util.List;

public interface PersonnelService {
    Personnel addPersonnel(Personnel personnel);
    Personnel getPersonneleById(Long idPersonnel);
    List<Personnel> getAllPersonnels();
    Personnel updatePersonnel(Long idPersonnel, Personnel updatedPersonnel);
    void deletePersonnel(Long idPersonnel);
}
