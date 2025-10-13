package com.takima.chefkit.DTO;

import com.takima.chefkit.models.usersModel;

import java.time.LocalDateTime;

public class usersMapper {
    public static usersDTO toDto(usersModel user) {
        return usersDTO.builder()
                .idUtilisateur(user.getIdUtilisateur())
                .nomUtilisateur(user.getNomUtilisateur())
                .email(user.getEmail())
                .motDePasse(user.getMotDePasse())
                .role(user.getRole())
                .build();
    }

    public static usersModel fromDto(usersDTO userDto) throws java.io.IOException {
        return usersModel.builder()
                .idUtilisateur(userDto.getIdUtilisateur())
                .nomUtilisateur(userDto.getNomUtilisateur())
                .email(userDto.getEmail())
                .motDePasse(userDto.getMotDePasse())
                .role(userDto.getRole())
                .dateCreation(LocalDateTime.now())
                .build();
    }
}
