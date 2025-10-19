package com.takima.chefkit.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.takima.chefkit.DTO.loginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takima.chefkit.DTO.usersDTO;
import com.takima.chefkit.models.ingredientsModel;
import com.takima.chefkit.models.usersModel;
import com.takima.chefkit.services.usersService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class usersController {
    private final usersService usersService;

    public usersController(usersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("")
    public List<usersModel> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public usersModel getuserById(@PathVariable int id) {
        return usersService.findUserById(id);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Object> getUserByUsername(@PathVariable String username) {
        List<usersModel> users = usersService.findUserByUsername(username);
        if (users.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else if (users.size() > 1) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Multiple users found, please be more specific");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(users.get(0), HttpStatus.OK);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getUserCount() {
        return usersService.getUserCount();
    }

    @PostMapping("")
    public void createUser(@RequestBody usersDTO usersDto) {
        usersService.addUsers(usersDto);
    }

    @PostMapping("/{id}")
    public void updateUserById(@PathVariable int id, @RequestBody usersDTO usersDto) {
        usersService.updateUsersById(id, usersDto);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody loginDTO loginDto) {
        System.out.println(loginDto);
        return usersService.loginUsers(loginDto);
    }

    @PostMapping("/update/{username}")
    public void updateUsersByUsername(@PathVariable String username, @RequestBody usersDTO usersDto) {
        usersService.updateUserByUsername(username, usersDto);
    }

    @DeleteMapping("/delete/{username}")
    public void deleteUserByUsername(@PathVariable String username) {
        usersService.deleteUserByUsername(username);
    }

    @GetMapping("/{username}/fridge")
    public List<ingredientsModel> getFridgeByUsername(@PathVariable String username) {
        return usersService.getFridgeByUsername(username);
    }

    @PostMapping("/{username}/fridge")
    public ResponseEntity<Void> addIngredientToFridge(@PathVariable String username, @RequestBody Long ingredientId) {
        usersService.addIngredientToFridgeByUsername(username, ingredientId);
        return ResponseEntity.ok().build();
    }
}