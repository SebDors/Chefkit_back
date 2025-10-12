package com.takima.chefkit.controllers;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public void deleteRecetteById(@PathVariable int id) {
        recettesService.deleteRecette(id);
    }

    @PostMapping("")
    public void createRecette(@RequestBody recettesDTO recetteDTO) {
        recettesService.addRecette(recetteDTO);
    }

    @PostMapping("/{id}")
    public void updateRecette(@PathVariable int id, @RequestBody recettesDTO recetteDTO) {
        recettesService.updateRecette(id, recetteDTO);
    }
}