package com.takima.chefkit.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.takima.chefkit.DAO.recettesDAO;
import com.takima.chefkit.DTO.recettesDTO;
import com.takima.chefkit.DTO.recettesMapper;
import com.takima.chefkit.models.recettesModel;

@Service
@Transactional
public class recettesService {
    private final recettesDAO recettesDAO;

    public recettesService(recettesDAO recettesDAO) {
        this.recettesDAO = recettesDAO;
    }

    @Transactional(readOnly = true)
    public List<recettesModel> getAllRecettes() {
        return recettesDAO.findAll();
    }

    @Transactional(readOnly = true)
    public recettesModel findRecetteById(int id) {
        return recettesDAO.findById((long) id).orElseThrow();
    }

    public void deleteRecette(int id) {
        recettesDAO.deleteById((long) id);
    }

    public recettesModel addRecette(recettesDTO recetteDto) {
        return recettesDAO.save(recettesMapper.fromDto(recetteDto));
    }

    public recettesModel updateRecette(int id, recettesDTO recetteDto) {
        recettesModel existingRecette = recettesDAO.findById((long) id).orElseThrow();
        existingRecette.setTitre(recetteDto.getTitre());
        existingRecette.setDescription(recetteDto.getDescription());
        existingRecette.setInstructions(recetteDto.getInstructions());
        existingRecette.setTempsPreparationMinutes(recetteDto.getTempsPreparationMinutes());
        existingRecette.setTempsCuissonMinutes(recetteDto.getTempsCuissonMinutes());
        existingRecette.setNombrePersonnes(recetteDto.getNombrePersonnes());
        existingRecette.setPathImage(recetteDto.getPathImage());
        return recettesDAO.save(existingRecette);
    }
}