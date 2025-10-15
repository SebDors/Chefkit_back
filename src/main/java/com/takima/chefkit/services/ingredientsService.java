package com.takima.chefkit.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.takima.chefkit.DAO.ingredientsDAO;
import com.takima.chefkit.DTO.ingredientsDTO;
import com.takima.chefkit.DTO.ingredientsMapper;
import com.takima.chefkit.models.ingredientsModel;

@Service
@Transactional
public class ingredientsService {
    private final ingredientsDAO ingredientsDao;

    public ingredientsService(ingredientsDAO ingredientsDao) {
        this.ingredientsDao = ingredientsDao;
    }

    public List<ingredientsModel> getAllIngredient() {
        return ingredientsDao.findAll();
    }

    public ingredientsModel findIngredientById(int id) {
        return ingredientsDao.findById((long) id).orElseThrow();
    }

    public void deleteIngredient(int id) {
        ingredientsDao.deleteById((long) id);
    }

    public void addIngredient(ingredientsDTO ingredientsDto) {
        ingredientsDao.save(ingredientsMapper.fromDto(ingredientsDto));
    }

    public ingredientsModel updateIngredient(int id, ingredientsDTO ingredientsDto) {
        ingredientsModel existingIngredient = ingredientsDao.findById((long) id).orElseThrow();
        existingIngredient.setNomIngredient(ingredientsDto.getNomIngredient());
        existingIngredient.setCategorie(ingredientsDto.getCategorie());
        return ingredientsDao.save(existingIngredient);
    }

    public int getIngredientCount() {
        return (int) ingredientsDao.count();
    }

    @Transactional(readOnly = true)
    public ingredientsModel findIngredientByNom(String nom) {
        return ingredientsDao.findByNomIngredientContainingIgnoreCase(nom);
    }

    public void deleteIngredientByNom(String nom) {
        ingredientsDao.deleteByNomIngredientContainingIgnoreCase(nom);
    }

    public ingredientsModel updateIngredientByNom(String nom, ingredientsDTO ingredientsDto) {
        ingredientsModel existingIngredient = ingredientsDao.findByNomIngredientContainingIgnoreCase(nom);
        if (ingredientsDto.getNomIngredient() != null && !ingredientsDto.getNomIngredient().trim().isEmpty()) {
            existingIngredient.setNomIngredient(ingredientsDto.getNomIngredient());
        }
        if (ingredientsDto.getCategorie() != null && !ingredientsDto.getCategorie().trim().isEmpty()) {
            existingIngredient.setCategorie(ingredientsDto.getCategorie());
        }
        return ingredientsDao.save(existingIngredient);
    }
}
