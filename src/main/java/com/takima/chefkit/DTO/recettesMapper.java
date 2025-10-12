package com.takima.chefkit.DTO;

import com.takima.chefkit.models.recettesModel;

public class recettesMapper {
    public static recettesDTO toDto(recettesModel recette) {
        return recettesDTO.builder()
                .idRecette(recette.getIdRecette())
                .titre(recette.getTitre())
                .description(recette.getDescription())
                .instructions(recette.getInstructions())
                .tempsPreparationMinutes(recette.getTempsPreparationMinutes())
                .tempsCuissonMinutes(recette.getTempsCuissonMinutes())
                .nombrePersonnes(recette.getNombrePersonnes())
                .pathImage(recette.getPathImage())
                .build();
    }

    public static recettesModel fromDto(recettesDTO recetteDto) {
        return recettesModel.builder()
                .idRecette(recetteDto.getIdRecette())
                .titre(recetteDto.getTitre())
                .description(recetteDto.getDescription())
                .instructions(recetteDto.getInstructions())
                .tempsPreparationMinutes(recetteDto.getTempsPreparationMinutes())
                .tempsCuissonMinutes(recetteDto.getTempsCuissonMinutes())
                .nombrePersonnes(recetteDto.getNombrePersonnes())
                .pathImage(recetteDto.getPathImage())
                .build();
    }
}