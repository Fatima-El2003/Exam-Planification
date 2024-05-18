package com.ensah.examplan.controller;

import com.ensah.examplan.model.Examen;
import com.ensah.examplan.model.Salle;
import com.ensah.examplan.model.Semestre;
import com.ensah.examplan.service.ExamenService;
import com.ensah.examplan.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalTime;
import java.util.Date;
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
    public Examen createExamen(
            @RequestParam("idSemestre") Long idSemestre,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam("heureDebut") @DateTimeFormat(pattern = "HH:mm") LocalTime heureDebut,
            @RequestParam("dureePrevue") Double dureePrevue,
            @RequestParam("dureeRelle") Double dureeRelle,
            @RequestParam("rapportTextuelle") String rapportTextuelle,
            @RequestParam("epreuve") MultipartFile epreuveFile,
            @RequestParam("pv") MultipartFile pvFile
    ) {
        Examen examen = new Examen();
        examen.setIdSemestre(idSemestre);
        examen.setDate(date);
        examen.setHeureDebut(heureDebut);
        examen.setDureePrevue(dureePrevue);
        examen.setDureeRelle(dureeRelle);
        examen.setRapportTextuelle(rapportTextuelle);

        return examenService.addExamen(examen, epreuveFile, pvFile);
    }
}
