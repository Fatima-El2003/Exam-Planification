package com.ensah.examplan.controller;


import com.ensah.examplan.model.Department;
import com.ensah.examplan.model.Enseignant;
import com.ensah.examplan.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements")
@CrossOrigin("http://localhost:3000/")
public class DepartementController {
    @Autowired
    DepartementService departementService;
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartements(){
        List<Department> departements = departementService.getAllDepartements();
        return ResponseEntity.ok(departements);
    }
    @GetMapping("{id}")
    public ResponseEntity<Department> geDepartmentById(@PathVariable("id") Long id){
        Department department = departementService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }
}
