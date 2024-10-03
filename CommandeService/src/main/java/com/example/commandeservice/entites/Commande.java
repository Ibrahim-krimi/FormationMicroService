package com.example.commandeservice.entites;

import com.example.commandeservice.dtos.ProduitDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomClient;

    private String description;


    @Transient
    private ProduitDto[]  produits;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<Long> produitsid;
}
