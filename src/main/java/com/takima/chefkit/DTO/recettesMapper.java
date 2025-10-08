package com.takima.chefkit.DTO;

import com.takima.chefkit.models.recettesModel;

public class recettesMapper {
    public static recettesDTO toDto(recettesModel recette) {
        recettesDTO recetteDto = new recettesDTO();
        recetteDto.setIdRecette(recette.getIdRecette());
        recetteDto.setTitre(recette.getTitre());
        recetteDto.setDescription(recette.getDescription());
        recetteDto.setInstructions(recette.getInstructions());
        recetteDto.setTempsPreparationMinutes(recette.getTempsPreparationMinutes());
        recetteDto.setTempsCuissonMinutes(recette.getTempsCuissonMinutes());
        recetteDto.setNombrePersonnes(recette.getNombrePersonnes());
        recetteDto.setPathImage(recette.getPathImage());
        return recetteDto;
    }

    public static recettesModel fromDto(recettesDTO recetteDto) {
        recettesModel recette = new recettesModel();
        recette.setIdRecette(recetteDto.getIdRecette());
        recette.setTitre(recetteDto.getTitre());
        recette.setDescription(recetteDto.getDescription());
        recette.setInstructions(recetteDto.getInstructions());
        recette.setTempsPreparationMinutes(recetteDto.getTempsPreparationMinutes());
        recette.setTempsCuissonMinutes(recetteDto.getTempsCuissonMinutes());
        recette.setNombrePersonnes(recetteDto.getNombrePersonnes());
        recette.setPathImage(recetteDto.getPathImage());
        return recette;
    }
}