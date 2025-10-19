package com.takima.chefkit.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class usersDTO {
    private Long idUtilisateur;
    private String nomUtilisateur;
    private String email;
    private String motDePasse;
    private String role;
}