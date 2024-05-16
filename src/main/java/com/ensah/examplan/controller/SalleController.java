//package com.ensah.examplan.controller;
//
//import com.ensah.examplan.model.Examen;
//import com.ensah.examplan.model.Salle;
//import com.ensah.examplan.service.ExamenService;
//import com.ensah.examplan.service.SalleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/salles")
//public class SalleController {
//    @Autowired
//    private SalleService salleService;
//    @PostMapping
//    public ResponseEntity<Salle> addSalle(@RequestBody Salle salle){
//        Salle savedSalle = salleService.addSalle(salle);
//        return new ResponseEntity<>(savedSalle, HttpStatus.CREATED);
//    }
//}
