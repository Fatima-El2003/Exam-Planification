package com.ensah.examplan.controller;

import com.ensah.examplan.model.ElementPedagogique;
import com.ensah.examplan.model.Enseignant;
import com.ensah.examplan.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
@CrossOrigin("http://localhost:3000/")
public class EnseignantController {
    @Autowired
    private EnseignantService enseignantService;
    @PostMapping()
    public ResponseEntity<Enseignant> addEnseignant(@RequestBody Enseignant enseignant){
        List<ElementPedagogique> elementPedagogiques = enseignant.getElementPedagogiques();
        if (elementPedagogiques != null) {
            for (ElementPedagogique elementPedagogique : elementPedagogiques ) {
                elementPedagogique.setEnseignant(enseignant); // Set the owner for each car
            }
        }
        Enseignant savedEnseignant = enseignantService.addEnseignant(enseignant);
        return new ResponseEntity<>(savedEnseignant, HttpStatus.CREATED);
    }
    @GetMapping("{idEnseignant}")
    public ResponseEntity<Enseignant> getEnseignantById(@PathVariable("idEnseignant") Long id){
        Enseignant enseignant = enseignantService.getEnseignantById(id);
        return ResponseEntity.ok(enseignant);
    }
    @GetMapping
    public ResponseEntity<List<Enseignant>> getAllEnseignants(){
        List<Enseignant> enseignants = enseignantService.getAllEnseignants();
        return ResponseEntity.ok(enseignants);
    }
    @PutMapping("{idEnseignant}")
    public ResponseEntity<Enseignant> updateEnseignant(@PathVariable("idEnseignant") Long id,@RequestBody Enseignant updatedEnseignant){
        Enseignant enseignant = enseignantService.updateEnseignant(id, updatedEnseignant);
        return ResponseEntity.ok(enseignant);
    }
    @DeleteMapping("{idEnseignant}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable("idEnseignant") Long id){
        enseignantService.deleteEnseignant(id);
        return ResponseEntity.ok("Personnel deleted successfully");
    }
}
