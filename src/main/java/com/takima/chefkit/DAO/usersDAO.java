package com.takima.chefkit.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takima.chefkit.models.usersModel;

@Repository
public interface usersDAO extends JpaRepository<usersModel, Long> {
    List<usersModel> findByNomUtilisateurContainingIgnoreCase(String nomUtilisateur);

    public void deleteByNomUtilisateurContainingIgnoreCase(String nomUtilisateur);

}
