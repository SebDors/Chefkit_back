package com.takima.chefkit.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takima.chefkit.models.ingredientsModel;

@Repository
public interface ingredientsDAO extends JpaRepository<ingredientsModel, Long> {
    ingredientsModel findByNomIngredientContainingIgnoreCase(String nomIngredient);
    void deleteByNomIngredientContainingIgnoreCase(String nomIngredient);
}
