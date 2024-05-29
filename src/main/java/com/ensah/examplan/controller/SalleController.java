package com.ensah.examplan.controller;

import com.ensah.examplan.model.Admin;
import com.ensah.examplan.model.Salle;
import com.ensah.examplan.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salles")
@CrossOrigin("http://localhost:3000/")
public class SalleController {
    @Autowired
    private SalleService salleService;
    @PostMapping
    public ResponseEntity<Salle> addSalle(@RequestBody Salle salle){
        Salle savedSalle = salleService.addSalle(salle);
        return new ResponseEntity<>(savedSalle, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Salle> getSalles( ){
       return salleService.getSalles();

    }
    @GetMapping("/examen/{examenId}")
    public List<Salle> getSallesByExamenId(@PathVariable Long examenId) {
        return salleService.getSallesByExamenId(examenId);
    }

}
