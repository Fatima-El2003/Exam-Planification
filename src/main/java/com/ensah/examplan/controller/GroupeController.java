package com.ensah.examplan.controller;

import com.ensah.examplan.model.Filiere;
import com.ensah.examplan.model.Groupe;
import com.ensah.examplan.model.Semestre;
import com.ensah.examplan.service.GroupeService;
import com.ensah.examplan.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groupes")
@CrossOrigin("http://localhost:3000/")
public class GroupeController {
    @Autowired
    GroupeService groupeService;
    @GetMapping
    public ResponseEntity<List<Groupe>> getAllGroupes(){
        List<Groupe> groupes = groupeService.getAllGroupes();
        return ResponseEntity.ok(groupes);
    }
    @GetMapping("{idGroupe}")
    public ResponseEntity<Groupe> getGroupeById(@PathVariable("idGroupe") Long id){
        Groupe groupe = groupeService.getGroupeById(id);
        return ResponseEntity.ok(groupe);
    }
}
