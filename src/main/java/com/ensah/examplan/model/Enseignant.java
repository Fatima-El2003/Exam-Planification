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
<<<<<<< HEAD
    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("enseignant")
    private List<ElementPedagogique> elementPedagogiques=new ArrayList<>();
    @Column(name ="id_department")
    Long idDepartment;
    @Column(name = "id_filiere")
    Long idFiliere;
    @Column(name = "id_groupe")
    Long idGroupe;
=======
    private String password;

    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("enseignant")
    private List<ElementPedagogique> elementPedagogiques=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "idDepartment")
    @JsonIgnoreProperties("enseignants")
    Department department;
    @ManyToOne
    @JoinColumn(name = "filiere_id",referencedColumnName = "idFiliere")
    @JsonIgnoreProperties("enseignants")
    Filiere filiere;
    @ManyToOne
    @JoinColumn(name = "groupe_id",referencedColumnName = "idGroupe")
    @JsonIgnoreProperties("enseignants")
    Groupe groupe;

>>>>>>> origin/master
}
