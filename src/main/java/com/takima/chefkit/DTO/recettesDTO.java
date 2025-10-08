package com.takima.chefkit.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class recettesDTO {
    private int idRecette;
    private String titre;
    private String description;
    private String instructions;
    private int tempsPreparationMinutes;
    private int tempsCuissonMinutes;
    private int nombrePersonnes;
    private String pathImage;
}