package com.ensah.examplan.controller;

import com.ensah.examplan.model.Admin;
import com.ensah.examplan.model.Semestre;
import com.ensah.examplan.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/semestres")
@CrossOrigin("http://localhost:3000/")
public class SemestreController {
    @Autowired
    SemestreService semestreService;
    @GetMapping
    public ResponseEntity<List<Semestre>> getAllSemestres(){
        List<Semestre> semestres = semestreService.getAllSemestres();
        return ResponseEntity.ok(semestres);
    }
}
