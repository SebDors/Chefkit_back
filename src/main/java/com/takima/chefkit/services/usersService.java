package com.takima.chefkit.services;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.takima.chefkit.DAO.usersDAO;
import com.takima.chefkit.DTO.usersDTO;
import com.takima.chefkit.DTO.usersMapper;
import com.takima.chefkit.models.usersModel;

@Service
@Transactional
public class usersService {
    private final usersDAO usersDAO;

    public usersService(usersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Transactional(readOnly = true)
    public List<usersModel> getAllUsers() {
        return usersDAO.findAll();
    }

    @Transactional(readOnly = true)
    public usersModel findUserById(int id) {
        return usersDAO.findById((long) id).orElseThrow();
    }

    public void deleteUser(int id) {
        usersDAO.deleteById((long) id);
    }

    public usersModel addUsers(usersDTO userDto) {
        try {
            return usersDAO.save(usersMapper.fromDto(userDto));
        } catch (IOException e) {
            throw new RuntimeException("Error with users image", e);
        }
    }

    public usersModel updateUsers(int id, usersDTO userDto) {
        usersModel existingUser = usersDAO.findById((long) id).orElseThrow();
        existingUser.setNomUtilisateur(userDto.getNomUtilisateur());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setMotDePasse(userDto.getMotDePasse());
        return usersDAO.save(existingUser);
    }

    public ResponseEntity<String> loginUsers(usersDTO userDto) {
        try {
            usersModel existingUser = usersDAO.findByNomUtilisateurContainingIgnoreCase(userDto.getNomUtilisateur());
            if (existingUser.getMotDePasse().equals(userDto.getMotDePasse())) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(401).body("Mot de passe incorrect");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(404).body("Utilisateur non trouvé");
        }
    }

}
