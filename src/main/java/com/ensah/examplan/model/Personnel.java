package com.ensah.examplan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> origin/master

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long idPersonnel;
    private String nom;
    private String prenom;
    @Column(name = "type", insertable = false, updatable = false)
    private String type;
    private Long idSalle;
<<<<<<< HEAD
=======
    // creneaux
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id_personnel")
    private List<Creneaux> creneaux;
>>>>>>> origin/master
}
