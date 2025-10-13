package com.takima.chefkit.controllers;

import java.util.List;
import java.util.Map;

import com.takima.chefkit.DTO.loginDTO;
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
    public usersModel getStudentById(@PathVariable int id) {
        return usersService.findUserById(id);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getUserCount() {
        return usersService.getUserCount();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        usersService.deleteUser(id);
    }

    @PostMapping("")
    public void createUser(@RequestBody usersDTO usersDTO) {
        usersService.addUsers(usersDTO);
    }

    @PostMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody usersDTO usersDTO) {
        usersService.updateUsers(id, usersDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody loginDTO loginDto) {
        System.out.println(loginDto);
        return usersService.loginUsers(loginDto);
    }
}
