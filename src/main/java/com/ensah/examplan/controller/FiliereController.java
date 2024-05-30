package com.ensah.examplan.controller;

import com.ensah.examplan.model.Department;
import com.ensah.examplan.model.Filiere;
import com.ensah.examplan.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filieres")
@CrossOrigin("http://localhost:3000/")
public class FiliereController {
    @Autowired
    FiliereService filiereService;
    @GetMapping
    public ResponseEntity<List<Filiere>> getAllFilieres(){
        List<Filiere> filieres = filiereService.getAllFilieres();
        return ResponseEntity.ok(filieres);
    }
    @GetMapping("{idFiliere}")
    public ResponseEntity<Filiere> geFiliereById(@PathVariable("idFiliere") Long id){
        Filiere filiere = filiereService.getFiliereById(id);
        return ResponseEntity.ok(filiere);
    }
}
