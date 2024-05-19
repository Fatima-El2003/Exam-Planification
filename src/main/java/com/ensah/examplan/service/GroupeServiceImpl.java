package com.ensah.examplan.service;

import com.ensah.examplan.model.Groupe;
import com.ensah.examplan.repository.ExamenRepository;
import com.ensah.examplan.repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeServiceImpl implements GroupeService {
    @Autowired
    private GroupeRepository groupeRepository;
    @Override
    public List<Groupe> getAllGroupes() {
        return  groupeRepository.findAll();
    }
}
