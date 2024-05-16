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
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long idFiliere;
    private String nomFiliere;
    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("filiere")
    private List<Enseignant> enseignants=new ArrayList<>();
}
