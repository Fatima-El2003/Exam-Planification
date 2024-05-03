package com.ensah.examplan.service;

import com.ensah.examplan.exception.ResourceNotFoundException;
import com.ensah.examplan.model.Personnel;
import com.ensah.examplan.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelServiceImpl implements PersonnelService{
    @Autowired
    private PersonnelRepository personnelRepository;

    @Override
    public Personnel addPersonnel(Personnel personnel) {
        return personnelRepository.save(personnel);
    }

    @Override
    public Personnel getPersonneleById(Long idPersonnel) {
        return personnelRepository.findById(idPersonnel).orElseThrow(() -> new ResourceNotFoundException("le personnel ave cet id n'existe pas" +idPersonnel ));
    }

    @Override
    public List<Personnel> getAllPersonnels() {
        return personnelRepository.findAll();
    }

    @Override
    public Personnel updatePersonnel(Long idPersonnel, Personnel updatedPersonnel) {
        Personnel personnel = getPersonneleById(idPersonnel);
        personnel.setNom(updatedPersonnel.getNom());
        personnel.setPrenom(updatedPersonnel.getPrenom());
        personnel.setType(updatedPersonnel.getType());
        return personnelRepository.save(personnel);
    }

    @Override
    public void deletePersonnel(Long idPersonnel) {
        personnelRepository.deleteById(idPersonnel);
    }

}
