package com.takima.chefkit.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ingredientsModel getIngredientById(@PathVariable Long id) {
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
    public void updateIngredient(@PathVariable Long id, @RequestBody ingredientsDTO ingredient) {
        ingredientsService.updateIngredient(id, ingredient);
    }

    @DeleteMapping("{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientsService.deleteIngredient(id);
    }

    @GetMapping("/nom/{nom_ingredient}")
    public ResponseEntity<Object> getIngredientByNom(@PathVariable String nom_ingredient) {
        List<ingredientsModel> ingredients = ingredientsService.findIngredientByNom(nom_ingredient);
        if (ingredients.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Ingredient not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else if (ingredients.size() > 1) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Multiple ingredients found, please be more specific");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(ingredients.get(0), HttpStatus.OK);
        }
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