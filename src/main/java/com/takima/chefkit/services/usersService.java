package com.takima.chefkit.services;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.takima.chefkit.DTO.loginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.takima.chefkit.DAO.usersDAO;
import com.takima.chefkit.DTO.usersDTO;
import com.takima.chefkit.DTO.usersMapper;
import com.takima.chefkit.models.ingredientsModel;
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

    @Transactional(readOnly = true)
    public usersModel findUserByUsername(String username) {
        return usersDAO.findByNomUtilisateur(username);
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

    public void updateUsersById(int id, usersDTO userDto) {
        usersModel existingUser = usersDAO.findById((long) id).orElseThrow();
        existingUser.setNomUtilisateur(userDto.getNomUtilisateur());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setMotDePasse(userDto.getMotDePasse());
        usersDAO.save(existingUser);
    }

    public ResponseEntity<Map<String, Object>> loginUsers(loginDTO loginDto) {
        usersModel existingUser = usersDAO.findByNomUtilisateurContainingIgnoreCase(loginDto.getNomUtilisateur());

        if (existingUser == null) {
            return ResponseEntity.status(404).body(Map.of("message", "Utilisateur non trouvé"));
        }

        if (existingUser.getMotDePasse().equals(loginDto.getMotDePasse())) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("role", existingUser.getRole());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "Mot de passe incorrect"));
        }
    }

    public ResponseEntity<Integer> getUserCount() {
        int user = (int) usersDAO.count();
        return ResponseEntity.ok(user);
    }

    public void updateUserByUsername(String username, usersDTO usersDto) {
        usersModel existingUser = usersDAO.findByNomUtilisateurContainingIgnoreCase(username);
        if (existingUser != null) {
            if (usersDto.getNomUtilisateur() != null && !usersDto.getNomUtilisateur().trim().isEmpty()) {
                existingUser.setNomUtilisateur(usersDto.getNomUtilisateur());
            }
            if (usersDto.getEmail() != null && !usersDto.getEmail().trim().isEmpty()) {
                existingUser.setEmail(usersDto.getEmail());
            }
            if (usersDto.getMotDePasse() != null && !usersDto.getMotDePasse().trim().isEmpty()) {
                existingUser.setMotDePasse(usersDto.getMotDePasse());
            }
            if (usersDto.getRole() != null && !usersDto.getRole().trim().isEmpty()) {
                existingUser.setRole(usersDto.getRole());
            }
            usersDAO.save(existingUser);
        }
    }

    public void deleteUserByUsername(String username) {
        usersDAO.deleteByNomUtilisateurContainingIgnoreCase(username);
    }

    public List<ingredientsModel> getFridgeByUserId(Long userId) {
        Optional<usersModel> user = usersDAO.findById(userId);
        if (user.isPresent()) {
            return user.get().getFridge();
        }
        return Collections.emptyList();
    }
}
