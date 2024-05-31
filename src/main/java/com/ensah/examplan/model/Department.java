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
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long idDepartment;
    private String nomDepartment;
<<<<<<< HEAD
    @OneToMany(mappedBy = "idDepartment", cascade = CascadeType.ALL, orphanRemoval = true)
=======
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
>>>>>>> origin/master
    @JsonIgnoreProperties("department")
    private List<Enseignant> enseignants=new ArrayList<>();
}
