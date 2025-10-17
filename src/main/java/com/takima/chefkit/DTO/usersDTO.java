package com.takima.chefkit.DTO;

import java.time.Instant;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class usersDTO {
    private int idUtilisateur;
    private String nomUtilisateur;
    private String email;
    private String motDePasse;
    private String role;
}