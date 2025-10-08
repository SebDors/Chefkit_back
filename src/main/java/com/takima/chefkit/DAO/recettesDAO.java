package com.takima.chefkit.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takima.chefkit.models.recettesModel;

@Repository
public interface recettesDAO extends JpaRepository<recettesModel, Long> {
    recettesModel findByTitreContainingIgnoreCase(String titre);
}