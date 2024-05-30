package com.ensah.examplan.service;

import com.ensah.examplan.exception.ResourceNotFoundException;
import com.ensah.examplan.model.Department;
import com.ensah.examplan.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartementServiceImpl implements DepartementService{
    @Autowired
    DepartementRepository departementRepository;
    @Override
    public List<Department> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long idDepartment) {
        return departementRepository.findById(idDepartment).orElseThrow(() -> new ResourceNotFoundException("le departement avec cet id n'existe pas" +idDepartment ));
    }

}
