package com.takima.chefkit.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.takima.chefkit.DTO.loginDTO;
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
}
