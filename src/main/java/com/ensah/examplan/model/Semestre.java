package com.ensah.examplan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long idSemestre;
    private String intitule;
    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("semestre")
    private Set<Examen> examens = new HashSet<>();


}
