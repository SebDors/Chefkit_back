package com.takima.chefkit.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ingredientsDTO {
    private int idIngredient;
    private String nomIngredient;
    private String categorie;
}
