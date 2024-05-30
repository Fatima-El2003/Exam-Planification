package com.ensah.examplan.service;

import com.ensah.examplan.exception.ResourceNotFoundException;
import com.ensah.examplan.model.Enseignant;
import com.ensah.examplan.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantServiceImpl implements EnseignantService{
    @Autowired
    private EnseignantRepository enseignantRepository;

    @Override
    public Enseignant addEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant getEnseignantById(Long idEnseignant) {
        return enseignantRepository.findById(idEnseignant).orElseThrow(() -> new ResourceNotFoundException("le personnel ave cet id n'existe pas" +idEnseignant ));
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant updateEnseignant(Long idEnseignant, Enseignant updatedEnseignant) {
        Enseignant enseignant = getEnseignantById(idEnseignant);
        enseignant.setNom(updatedEnseignant.getNom());
        enseignant.setPrenom(updatedEnseignant.getPrenom());
        enseignant.setIdSalle(updatedEnseignant.getIdSalle());
        enseignant.setIdGroupe(updatedEnseignant.getIdGroupe());
        enseignant.setIdDepartment(updatedEnseignant.getIdDepartment());
        enseignant.setIdFiliere(updatedEnseignant.getIdFiliere());
        enseignant.setEmail(updatedEnseignant.getEmail());
        return enseignantRepository.save(enseignant);
    }

    @Override
    public void deleteEnseignant(Long idEnseignant) {
        enseignantRepository.deleteById(idEnseignant);
    }
    @Override
    public List<Enseignant> getSurveillantsByGroupe(Long idGroupe, Long surveillantCount) {
        return enseignantRepository.findSurveillantsByGroupe(idGroupe, surveillantCount);
    }
}
