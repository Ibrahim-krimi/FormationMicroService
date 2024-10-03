package com.example.commandeservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDto {

    private Long id;
    private String nom;
    private Float prix;
    private Integer quantite;
    private String description;

}
