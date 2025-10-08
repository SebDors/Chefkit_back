package com.takima.chefkit.models;

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

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "recettes")
public class recettesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecette;

    @Column
    private String titre;

    @Column
    private String description;

    @Column
    private String instructions;

    @Column
    private int tempsPreparationMinutes;

    @Column
    private int tempsCuissonMinutes;

    @Column
    private int nombrePersonnes;

    @Column
    private String pathImage;
}