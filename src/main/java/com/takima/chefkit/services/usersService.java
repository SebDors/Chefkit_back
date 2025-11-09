package com.takima.chefkit.services;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.takima.chefkit.DTO.loginDTO;
import com.takima.chefkit.DAO.ingredientsDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.takima.chefkit.DAO.usersDAO;
import com.takima.chefkit.DAO.recettesDAO;
import com.takima.chefkit.DTO.usersDTO;
import com.takima.chefkit.DTO.usersMapper;
import com.takima.chefkit.models.ingredientsModel;
import com.takima.chefkit.models.recettesModel;
import com.takima.chefkit.models.usersModel;

@Service
@Transactional
public class usersService {
    private final usersDAO usersDAO;
    private final ingredientsDAO ingredientsDAO;
    private final recettesDAO recettesDAO;
    private final JdbcTemplate jdbcTemplate;

    public usersService(usersDAO usersDAO, ingredientsDAO ingredientsDAO, recettesDAO recettesDAO,
            JdbcTemplate jdbcTemplate) {
        this.usersDAO = usersDAO;
        this.ingredientsDAO = ingredientsDAO;
        this.recettesDAO = recettesDAO;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(readOnly = true)
    public List<usersModel> getAllUsers() {
        return usersDAO.findAll();
    }

    @Transactional(readOnly = true)
    public usersModel findUserById(Long id) {
        return usersDAO.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<usersModel> findUserByUsername(String username) {
        return usersDAO.findByNomUtilisateurContainingIgnoreCase(username);
    }

    public void deleteUser(Long id) {
        usersDAO.deleteById(id);
    }

    public usersModel addUsers(usersDTO userDto) {
        try {
            return usersDAO.save(usersMapper.fromDto(userDto));
        } catch (IOException e) {
            throw new RuntimeException("Error with users image", e);
        }
    }

    public void updateUsersById(Long id, usersDTO userDto) {
        usersModel existingUser = usersDAO.findById(id).orElseThrow();
        existingUser.setNomUtilisateur(userDto.getNomUtilisateur());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setMotDePasse(userDto.getMotDePasse());
        usersDAO.save(existingUser);
    }

    public ResponseEntity<Map<String, Object>> loginUsers(loginDTO loginDto) {
        List<usersModel> existingUsers = usersDAO
                .findByNomUtilisateurContainingIgnoreCase(loginDto.getNomUtilisateur());

        if (existingUsers.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of("message", "Utilisateur non trouvé"));
        }

        usersModel existingUser = existingUsers.get(0);

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
        List<usersModel> existingUsers = usersDAO.findByNomUtilisateurContainingIgnoreCase(username);
        if (!existingUsers.isEmpty()) {
            usersModel existingUser = existingUsers.get(0);
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

    public List<ingredientsModel> getFridgeByUsername(String username) {
        List<usersModel> users = usersDAO.findByNomUtilisateurContainingIgnoreCase(username);
        if (!users.isEmpty()) {
            return users.get(0).getFridge();
        }
        return Collections.emptyList();
    }

    public void addIngredientToFridgeByUsername(String username, Long ingredientId) {
        List<usersModel> users = usersDAO.findByNomUtilisateurContainingIgnoreCase(username);
        if (users.isEmpty()) {
            throw new RuntimeException("Utilisateur non trouvé avec le nom d'utilisateur " + username);
        }
        usersModel user = users.get(0);

        ingredientsModel ingredient = ingredientsDAO.findById(ingredientId)
                .orElseThrow(() -> new RuntimeException("Ingrédient non trouvé avec l'id " + ingredientId));

        // Ajoute l'ingrédient au frigo de l'utilisateur s'il n'y est pas déjà
        if (!user.getFridge().contains(ingredient)) {
            user.getFridge().add(ingredient);
            // La sauvegarde est gérée par @Transactional
            usersDAO.save(user);
        }
    }

    public void updateFridgeByUsername(String username, List<Long> ingredientIds) {
        List<usersModel> users = usersDAO.findByNomUtilisateurContainingIgnoreCase(username);
        if (users.isEmpty()) {
            throw new RuntimeException("Utilisateur non trouvé avec le nom d'utilisateur " + username);
        }
        usersModel user = users.get(0);

        // Vide le frigo actuel
        user.getFridge().clear();

        // Si la liste d'IDs n'est pas vide, on la remplit
        if (ingredientIds != null && !ingredientIds.isEmpty()) {
            List<ingredientsModel> ingredients = ingredientsDAO.findAllById(ingredientIds);
            user.setFridge(ingredients);
        }

        // Sauvegarde l'utilisateur avec son frigo mis à jour
        usersDAO.save(user);
    }

    public List<recettesModel> findRecipesByFridge(String username) {
        List<usersModel> users = usersDAO.findByNomUtilisateurContainingIgnoreCase(username);
        if (users.isEmpty()) {
            throw new RuntimeException("Utilisateur non trouvé avec le nom d'utilisateur " + username);
        }
        usersModel user = users.get(0);
        Long userId = user.getIdUtilisateur();

        String sql = "SELECT r.id_recette FROM recettes r " +
                "JOIN recette_ingredients ri ON r.id_recette = ri.id_recette " +
                "LEFT JOIN frigo_utilisateur fu ON ri.id_ingredient = fu.id_ingredient AND fu.id_utilisateur = ? " +
                "GROUP BY r.id_recette " +
                "HAVING CAST(COUNT(fu.id_ingredient) AS REAL) / COUNT(ri.id_ingredient) >= 0.5";

        List<Long> recipeIds = jdbcTemplate.queryForList(sql, new Object[] { userId }, Long.class);

        if (recipeIds.isEmpty()) {
            return Collections.emptyList();
        }

        return recettesDAO.findAllById(recipeIds);
    }
}