package com.takima.chefkit.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takima.chefkit.DTO.recettesDTO;
import com.takima.chefkit.models.recettesModel;
import com.takima.chefkit.services.recettesService;
import com.takima.chefkit.DTO.IngredientDetailDTO;

@RestController
@RequestMapping("/recettes")
@CrossOrigin
public class recettesController {
    private final recettesService recettesService;

    public recettesController(recettesService recettesService) {
        this.recettesService = recettesService;
    }

    @GetMapping("")
    public List<recettesModel> getAllRecettes() {
        return recettesService.getAllRecettes();
    }

    @GetMapping("/{id}")
    public recettesModel getRecetteById(@PathVariable int id) {
        return recettesService.findRecetteById(id);
    }

    @GetMapping("/titre/{titre}")
    public ResponseEntity<Object> getRecetteByTitre(@PathVariable String titre) {
        List<recettesModel> recettes = recettesService.findRecettesByTitre(titre);
        if (recettes.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Recette not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else if (recettes.size() > 1) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Multiple recettes found, please be more specific");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(recettes.get(0), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}/ingredients")
    public List<IngredientDetailDTO> getIngredientsByRecipeId(@PathVariable int id) {
        return recettesService.findIngredientsByRecipeId(id);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getRecetteCount() {
        return recettesService.getRecetteCount();
    }

    @DeleteMapping("/{id}")
    public void deleteRecetteById(@PathVariable int id) {
        recettesService.deleteRecetteById(id);
    }

    @DeleteMapping("/titre/{titre}")
    public void deleteRecetteByTitre(@PathVariable String titre) {recettesService.deleteRecetteByTitre(titre);}

    @PostMapping("")
    public void createRecette(@RequestBody recettesDTO recetteDTO) {
        recettesService.addRecette(recetteDTO);
    }

    @PostMapping("/{id}")
    public void updateRecetteById(@PathVariable int id, @RequestBody recettesDTO recetteDTO) {
        recettesService.updateRecetteById(id, recetteDTO);
    }

    @PostMapping("/titre/{titre}")
    public void updateRecetteByTitre(@PathVariable String titre, @RequestBody recettesDTO recetteDTO) {
        System.out.println(recetteDTO);
        recettesService.updateRecetteByTitre(titre, recetteDTO);
    }
}
