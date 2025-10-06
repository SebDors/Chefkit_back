package com.takima.chefkit.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Getter // Génère les getters
@Setter // Génère les setters
@Builder // Génère le builder pour plus tard (il parait que c'est utile)
@NoArgsConstructor // Génère un constructeur sans arguments

// Hibernate
@Entity
@Table(name = "utilisateurs") // Spécifie le nom de la table dans la bdd
public class usersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtilisateur;
    @Column
    private String nomUtilisateur;
    @Column
    private String email;
    @Column
    private String motDePasse;
    @Column
    private LocalDateTime dateCreation;

}
