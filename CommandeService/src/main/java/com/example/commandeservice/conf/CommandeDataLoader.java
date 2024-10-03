package com.example.commandeservice.conf;

import com.example.commandeservice.entites.Commande;
import com.example.commandeservice.repo.CommandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CommandeDataLoader {

    @Bean
    CommandLineRunner initDatabase(CommandeRepository commandeRepository) {
        return args -> {
            // Créer quelques commandes
            Commande commande1 = new Commande();
            commande1.setNomClient("John Doe");
            commande1.setDescription("Commande pour un ordinateur portable et une tablette");
            commande1.setProduitsid(Arrays.asList(1L, 3L)); // Liée aux produits 1 et 3

            Commande commande2 = new Commande();
            commande2.setNomClient("Jane Smith");
            commande2.setDescription("Commande pour deux smartphones");
            commande2.setProduitsid(Arrays.asList(2L, 2L)); // Liée au produit 2 deux fois (par exemple, acheter deux smartphones)

            Commande commande3 = new Commande();
            commande3.setNomClient("Alice Johnson");
            commande3.setDescription("Commande pour un smartphone et une tablette");
            commande3.setProduitsid(Arrays.asList(2L, 3L)); // Liée aux produits 2 et 3

            // Enregistrer les commandes dans la base de données
            commandeRepository.save(commande1);
            commandeRepository.save(commande2);
            commandeRepository.save(commande3);

            System.out.println("Commandes enregistrées dans la base de données.");
        };
    }
}
