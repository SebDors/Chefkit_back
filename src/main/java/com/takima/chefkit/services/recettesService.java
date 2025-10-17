package com.takima.chefkit.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.takima.chefkit.DAO.recettesDAO;
import com.takima.chefkit.DTO.recettesDTO;
import com.takima.chefkit.DTO.recettesMapper;
import com.takima.chefkit.models.recettesModel;
import com.takima.chefkit.DTO.IngredientDetailDTO;

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

    @Transactional(readOnly = true)
    public List<recettesModel> findRecettesByTitre(String titre) {
        return recettesDAO.findByTitreContainingIgnoreCase(titre);
    }

    public List<IngredientDetailDTO> findIngredientsByRecipeId(int id) {
        return recettesDAO.findIngredientsByRecipeId((long) id);
    }

    public void deleteRecetteById(int id) {
        recettesDAO.deleteById((long) id);
    }

    public void deleteRecetteByTitre(String titre) {
        recettesDAO.deleteByTitreContainingIgnoreCase(titre);
    }

    public void addRecette(recettesDTO recetteDto) {
        recettesDAO.save(recettesMapper.fromDto(recetteDto));
    }

    public void updateRecetteById(int id, recettesDTO recetteDto) {
        recettesModel existingRecette = recettesDAO.findById((long) id).orElseThrow();
        updateDtoToExistingModel(recetteDto, existingRecette);
        recettesDAO.save(existingRecette);
    }

    public void updateRecetteByTitre(String Titre, recettesDTO recetteDto) {
        List<recettesModel> existingRecettes = recettesDAO.findByTitreContainingIgnoreCase(Titre);
        if (!existingRecettes.isEmpty()) {
            recettesModel existingRecette = existingRecettes.get(0);
            updateDtoToExistingModel(recetteDto, existingRecette);
            recettesDAO.save(existingRecette);
        } else {
            throw new RuntimeException("Recette with titre " + Titre + " not found.");

        }
    }

    private void updateDtoToExistingModel(recettesDTO recetteDto, recettesModel existingRecette) {
        if (recetteDto.getTitre() != null &&  !recetteDto.getTitre().isEmpty()) {
            existingRecette.setTitre(recetteDto.getTitre());
        }
        if (recetteDto.getDescription() != null &&   !recetteDto.getDescription().isEmpty()) {
            existingRecette.setDescription(recetteDto.getDescription());
        }
        if (recetteDto.getInstructions() != null &&  !recetteDto.getInstructions().isEmpty()) {
            existingRecette.setInstructions(recetteDto.getInstructions());
        }
        if (recetteDto.getTempsPreparationMinutes() > 0) {
            existingRecette.setTempsPreparationMinutes(recetteDto.getTempsPreparationMinutes());
        }
        if (recetteDto.getTempsCuissonMinutes() > 0) {
            existingRecette.setTempsCuissonMinutes(recetteDto.getTempsCuissonMinutes());
        }
        if (recetteDto.getNombrePersonnes() > 0) {
            existingRecette.setNombrePersonnes(recetteDto.getNombrePersonnes());
        }
        if (recetteDto.getPathImage() != null &&  !recetteDto.getPathImage().isEmpty()) {
            existingRecette.setPathImage(recetteDto.getPathImage());
        }
    }

    public ResponseEntity<Integer> getRecetteCount() {
        int recette = (int) recettesDAO.count();
        return ResponseEntity.ok(recette);
    }
}
