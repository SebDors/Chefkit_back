package com.takima.chefkit.DTO;

import com.takima.chefkit.models.ingredientsModel;

public class ingredientsMapper {
    public static ingredientsDTO toDto(ingredientsModel ingredients) {
        return ingredientsDTO.builder()
                .idIngredient(ingredients.getIdIngredient())
                .nomIngredient(ingredients.getNomIngredient())
                .categorie(ingredients.getCategorie())
                .build();
    }

    public static ingredientsModel fromDto(ingredientsDTO ingredients) {
        return ingredientsModel.builder()
                .idIngredient(ingredients.getIdIngredient())
                .nomIngredient(ingredients.getNomIngredient())
                .categorie(ingredients.getCategorie())
                .build();
    }
}
