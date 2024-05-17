package com.ensah.examplan.controller;

import com.ensah.examplan.model.Examen;
import com.ensah.examplan.model.Salle;
import com.ensah.examplan.model.Semestre;
import com.ensah.examplan.service.ExamenService;
import com.ensah.examplan.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/examens")
@CrossOrigin("http://localhost:3000/")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @Autowired
    private SemestreService semestreService;

    @PostMapping
    public ResponseEntity<String> addExamens(@RequestBody Examen examen) {
        // Ensure that 'idSemestre' is provided in the JSON payload
        Long semestreId = examen.getIdSemestre();

        if (semestreId == null) {
            return new ResponseEntity<>("Semestre ID is required", HttpStatus.BAD_REQUEST);
        }

        // Retrieve the existing Semestre from the database based on the ID
        Semestre semestre = semestreService.getSemestreById(semestreId);
        if (semestre == null) {
            return new ResponseEntity<>("Semestre with ID " + semestreId + " not found", HttpStatus.NOT_FOUND);
        }

        // Set the retrieved Semestre ID in the Examen
        examen.setIdSemestre(semestreId);

        // Set the owner for each Salle associated with the Examen
        Set<Salle> salles = examen.getSalles();
        if (salles != null) {
            for (Salle salle : salles) {
                salle.setExamen(examen);
            }
        }

        // Save the Examen with the updated Semestre reference
        Examen savedExamen = examenService.addExamen(examen);
        return new ResponseEntity<>(String.valueOf(savedExamen.getIdExamen()), HttpStatus.CREATED);
    }
}
