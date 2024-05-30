package com.ensah.examplan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long idGroupe ;
    private String nom;
    @OneToMany(mappedBy = "idGroupe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("groupe")
    private List<Enseignant> enseignants=new ArrayList<>();
}
