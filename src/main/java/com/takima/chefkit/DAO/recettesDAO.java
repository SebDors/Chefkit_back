package com.takima.chefkit.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takima.chefkit.DTO.IngredientDetailDTO;
import com.takima.chefkit.models.recettesModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface recettesDAO extends JpaRepository<recettesModel, Long> {

    @Query(nativeQuery = true, value = "SELECT i.nom_ingredient AS name, ri.quantite AS quantity, ri.unite AS unit " +
            "FROM recette_ingredients ri " +
            "JOIN ingredients i ON ri.id_ingredient = i.id_ingredient " +
            "WHERE ri.id_recette = :recipeId")
    List<IngredientDetailDTO> findIngredientsByRecipeId(@Param("recipeId") Long recipeId);

    recettesModel findByTitreContainingIgnoreCase(String titre);
    void deleteByTitreContainingIgnoreCase(String titre);
}