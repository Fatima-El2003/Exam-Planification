package com.ensah.examplan.controller;

import com.ensah.examplan.model.Enseignant;
import com.ensah.examplan.model.Examen;
import com.ensah.examplan.model.Salle;
import com.ensah.examplan.service.EnseignantService;
import com.ensah.examplan.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/examens")
public class ExamenController {
    @Autowired
    private ExamenService examenService;
    @PostMapping
    public ResponseEntity<Examen> addExamens(@RequestBody Examen examen){
        Set<Salle> salles = examen.getSalles();
        if (salles != null) {
            for (Salle salle : salles ) {
                salle.setExamen(examen); // Set the owner for each car
            }
        }
        Examen savedExamen = examenService.addExamen(examen);
        return new ResponseEntity<>(savedExamen, HttpStatus.CREATED);
    }
}
