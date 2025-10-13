package com.takima.chefkit.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takima.chefkit.DTO.ingredientsDTO;
import com.takima.chefkit.models.ingredientsModel;
import com.takima.chefkit.services.ingredientsService;

@RestController
@RequestMapping("/ingredients")
@CrossOrigin
public class ingredientsController {
    private final ingredientsService ingredientsService;

    public ingredientsController(ingredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping("")
    public List<ingredientsModel> getAllIngredients() {
        return ingredientsService.getAllIngredient();
    }

    @GetMapping("{id}")
    public ingredientsModel getIngredientById(int id) {
        return ingredientsService.findIngredientById(id);
    }

    @PostMapping("")
    public void createIngredient(ingredientsDTO ingredient) {
        ingredientsService.addIngredient(ingredient);
    }

    @PostMapping("{id}")
    public void updateIngredient(int id, ingredientsDTO ingredient) {
        ingredientsService.updateIngredient(id, ingredient);
    }

    @DeleteMapping("{id}")
    public void deleteIngredient(int id) {
        ingredientsService.deleteIngredient(id);
    }

}
