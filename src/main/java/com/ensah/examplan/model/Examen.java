package com.ensah.examplan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import com.ensah.examplan.model.Salle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long idExamen;
    private Date date;
    private Double dureePrevue;
    private Double dureeRelle;
    private LocalTime heureDebut;
    private String type;
//    private String epreuve will be the file of the exam
//    private String pv;
    private String rapportTextuelle;
    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("examen")
    private Set<Salle> salles = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "idSession")
    @JsonIgnoreProperties("examen")
    private Session session;
    @ManyToOne
    @JoinColumn(name = "semestre_id", referencedColumnName = "idSemestre")//foreign key
    @JsonIgnoreProperties("examen")
    private Semestre semestre;
}
