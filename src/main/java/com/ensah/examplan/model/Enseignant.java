package com.ensah.examplan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enseignant extends Personnel{
    private Long idDepartment;
    private Long idFiliere;
    private Long idGroupe;
    @Column(unique = true)
    private String email;
    private String password;
}
