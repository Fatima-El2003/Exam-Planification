package com.ensah.examplan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Creneaux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCreneaux ;
    private String jour;
    private LocalTime heure_debut_dispo;
    private LocalTime heure_fin_dispo;



}
