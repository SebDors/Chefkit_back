package com.takima.chefkit.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/count")
    public int getIngredientCount() {
        return ingredientsService.getIngredientCount();
    }

    @PostMapping("")
    public void createIngredient(@RequestBody ingredientsDTO ingredient) {
        ingredientsService.addIngredient(ingredient);
    }

    @PostMapping("{id}")
    public void updateIngredient(@PathVariable int id, @RequestBody ingredientsDTO ingredient) {
        ingredientsService.updateIngredient(id, ingredient);
    }

    @DeleteMapping("{id}")
    public void deleteIngredient(int id) {
        ingredientsService.deleteIngredient(id);
    }

    @GetMapping("/nom/{nom_ingredient}")
    public ingredientsModel getIngredientByNom(@PathVariable String nom_ingredient) {
        return ingredientsService.findIngredientByNom(nom_ingredient);
    }

    @DeleteMapping("/delete/{nom_ingredient}")
    public void deleteIngredientByNom(@PathVariable String nom_ingredient) {
        ingredientsService.deleteIngredientByNom(nom_ingredient);
    }

    @PostMapping("/update/{nom_ingredient}")
    public void updateIngredientByNom(@PathVariable String nom_ingredient, @RequestBody ingredientsDTO ingredient) {
        ingredientsService.updateIngredientByNom(nom_ingredient, ingredient);
    }
}
