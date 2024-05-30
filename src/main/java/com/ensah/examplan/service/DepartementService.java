package com.ensah.examplan.service;

import com.ensah.examplan.model.Department;


import java.util.List;

public interface DepartementService {
    List<Department> getAllDepartements();
    Department getDepartmentById(Long idDepartment);
}
