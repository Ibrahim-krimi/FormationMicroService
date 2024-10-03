package com.example.produitservice.Config;

import com.example.produitservice.entites.Produit;
import com.example.produitservice.repo.ProduitRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProduitDataLoader {

    @Bean
    CommandLineRunner initDatabase(ProduitRespository produitRepository) {
        return args -> {
            // Créer quelques produits
            Produit produit1 = new Produit(null, "Laptop", 1000.0f, 10, "Un laptop performant");
            Produit produit2 = new Produit(null, "Smartphone", 500.0f, 20, "Un smartphone de dernière génération");
            Produit produit3 = new Produit(null, "Tablette", 300.0f, 15, "Une tablette légère et puissante");

            // Enregistrer les produits dans la base de données
            produitRepository.save(produit1);
            produitRepository.save(produit2);
            produitRepository.save(produit3);

            System.out.println("Produits enregistrés dans la base de données.");
        };
    }
}
