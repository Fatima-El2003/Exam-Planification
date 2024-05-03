package com.ensah.examplan.controller;

import com.ensah.examplan.model.Personnel;
import com.ensah.examplan.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personnels")
public class PersonnelController {
    @Autowired
    private PersonnelService personnelService;

    @PostMapping
    public ResponseEntity<Personnel> addPersonnel(@RequestBody Personnel personnel){
        Personnel savedPersonne = personnelService.addPersonnel(personnel);
        return new ResponseEntity<>(savedPersonne, HttpStatus.CREATED);
    }
    @GetMapping("{idPersonnel}")
    public ResponseEntity<Personnel> getPersonnelById(@PathVariable("idPersonnel") Long id){
        Personnel personnel = personnelService.getPersonneleById(id);
        return ResponseEntity.ok(personnel);
    }
    @GetMapping
    public ResponseEntity<List<Personnel>> getAllPersonnels(){
        List<Personnel> personnels = personnelService.getAllPersonnels();
        return ResponseEntity.ok(personnels);
    }
    @PutMapping("{idPersonnel}")
    public ResponseEntity<Personnel> updatePersonnel(@PathVariable("idPersonnel") Long id,@RequestBody Personnel updatedPersonnel){
        Personnel personnel = personnelService.updatePersonnel(id, updatedPersonnel);
        return ResponseEntity.ok(personnel);
    }
    @DeleteMapping("{idPersonnel}")
    public ResponseEntity<String> deletePersonnel(@PathVariable("idPersonnel") Long id){
        personnelService.deletePersonnel(id);
        return ResponseEntity.ok("Personnel deleted successfully");
    }
}
