package com.takima.chefkit.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takima.chefkit.models.usersModel;

@Repository
public interface usersDAO extends JpaRepository<usersModel, Long> {
    usersModel findByNomUtilisateurContainingIgnoreCase(String nomUtilisateur);
}
