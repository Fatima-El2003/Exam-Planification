package com.ensah.examplan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
    private String rapportTextuelle;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("examen")
    private Set<Salle> salles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "idSession")
    @JsonIgnoreProperties("examens")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "element_id", referencedColumnName = "idElemPedagogique")
    @JsonIgnoreProperties("examen")
    private ElementPedagogique element;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

    // Use this field to map the existing `id_semestre` column in the database
    @Column(name = "id_semestre")
    private Long idSemestre;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] epreuve;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] pv;
}
