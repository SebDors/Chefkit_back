package com.takima.chefkit.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    private Long idUtilisateur;
    @Column
    private String nomUtilisateur;
    @Column
    private String email;
    @Column
    private String motDePasse;
    @Column
    private String role;
    @Column
    private LocalDateTime dateCreation;

    @ManyToMany
    @JoinTable(name = "frigo_utilisateur", joinColumns = @JoinColumn(name = "id_utilisateur"), inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
    private List<ingredientsModel> fridge;

}
