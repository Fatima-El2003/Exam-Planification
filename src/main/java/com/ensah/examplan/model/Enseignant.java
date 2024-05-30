package com.ensah.examplan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enseignant extends Personnel{


   // private Long idGroupe;
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("enseignant")
    private List<ElementPedagogique> elementPedagogiques=new ArrayList<>();
    @Column(name ="id_department")
    Long idDepartment;
    @Column(name = "id_filiere")
    Long idFiliere;
    @Column(name = "id_groupe")
    Long idGroupe;
}
