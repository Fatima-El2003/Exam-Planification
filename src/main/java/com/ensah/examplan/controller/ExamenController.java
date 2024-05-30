package com.ensah.examplan.controller;

import com.ensah.examplan.model.Examen;
import com.ensah.examplan.model.Salle;
import com.ensah.examplan.service.ExamenService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin("http://localhost:3000/")
public class ExamenController {
    @Autowired
    private ExamenService examService;

    @PostMapping("/save")
    public Examen saveExam(
            @RequestParam("idSemestre") Long idSemestre,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam("heureDebut") @DateTimeFormat(pattern = "HH:mm") LocalTime heureDebut,
            @RequestParam("dureePrevue") Double dureePrevue,
            @RequestParam("dureeRelle") Double dureeRelle,
            @RequestParam("rapportTextuelle") String rapportTextuelle,
            @RequestParam("epreuve") MultipartFile epreuveFile,
            @RequestParam("pv") MultipartFile pvFile,
            @RequestParam("salles") String sallesJson,
            @RequestParam("idGroupe") Long idGroupe
           ) {
        Examen examen = new Examen();
        examen.setIdSemestre(idSemestre);
        examen.setDate(date);
        examen.setHeureDebut(heureDebut);
        examen.setDureePrevue(dureePrevue);
        examen.setDureeRelle(dureeRelle);
        examen.setRapportTextuelle(rapportTextuelle);

        Set<Salle> salles = new HashSet<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            salles = mapper.readValue(sallesJson, new TypeReference<Set<Salle>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse salles JSON", e);

        }
        System.out.println("Examen: " + examen);
        System.out.println("Salles: " + salles);
        System.out.println("Epreuve File: " + (epreuveFile != null ? epreuveFile.getOriginalFilename() : "null"));
        System.out.println("PV File: " + (pvFile != null ? pvFile.getOriginalFilename() : "null"));

        return examService.addExamen(examen, salles, epreuveFile, pvFile, idGroupe);

    }

    @GetMapping("/{id}")
    public Examen getExamenById(@PathVariable Long id) {
        return examService.getExamenById(id);
    }

    @GetMapping("/all")
    public List<Examen> getAllExamens() {
        return examService.getAllExamens();
    }

    @PutMapping("/{id}")
    public Examen updateExamen(@PathVariable Long id, @RequestBody Examen updatedExamen) {
        return examService.updateExamen(id, updatedExamen);
    }

    @DeleteMapping("/{id}")
    public void deleteExamen(@PathVariable Long id) {
        examService.deleteExamen(id);
    }
}
