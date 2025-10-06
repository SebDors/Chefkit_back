package com.takima.chefkit.DTO;

import com.takima.chefkit.models.usersModel;

public class usersMapper {
    public static usersDTO toDto(usersModel user) {
        usersDTO userDto = new usersDTO();
        userDto.setIdUtilisateur((int) user.getIdUtilisateur());
        userDto.setNomUtilisateur(user.getNomUtilisateur());
        userDto.setEmail(user.getEmail());
        userDto.setMotDePasse(user.getMotDePasse());
        return userDto;
    }

    public static usersModel fromDto(usersDTO userDto) throws java.io.IOException {
        usersModel user = new usersModel();
        user.setIdUtilisateur((int) userDto.getIdUtilisateur());
        user.setNomUtilisateur(userDto.getNomUtilisateur());
        user.setEmail(userDto.getEmail());
        user.setMotDePasse(userDto.getMotDePasse());
        return user;
    }
}
