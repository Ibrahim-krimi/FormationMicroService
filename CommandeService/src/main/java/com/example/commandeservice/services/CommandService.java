package com.example.commandeservice.services;

import com.example.commandeservice.dtos.ProduitDto;
import com.example.commandeservice.entites.Commande;
import com.example.commandeservice.repo.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class CommandService {

    private final CommandeRepository commandeRepository;
    private final RestTemplate restTemplate;
    @Value("${produit.service.url}")
    private String produitServiceUrl;
    @Autowired
    public  CommandService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
        this.restTemplate = new RestTemplate();
    }

    public List<Commande> getCommandes() {
        return commandeRepository.findAll();
    }

    public Commande getCommande(Long id) {

        Commande commande = this.commandeRepository.findById(id).orElse(null);

        if (commande!=null && commande.getProduitsid() != null) {
            ProduitDto [] produits = Arrays.stream(commande.getProduitsid().toArray(new Long[0]))
                    .map(this::getProduitById)
                    .toArray(ProduitDto[]::new);
            commande.setProduits(produits);
        }
        return commande;
    }

    private ProduitDto getProduitById(Long id) {
        System.out.println("Fetching product with ID: " + id);
        return restTemplate.getForObject(produitServiceUrl + id, ProduitDto.class);
    }

    public List<Commande> getCommandesWithProduct() {
        List<Commande> commandes = this.commandeRepository.findAll();

        for (Commande commande: commandes) {
            if (commande.getProduitsid() != null) {
                ProduitDto [] produits = Arrays.stream(commande.getProduitsid().toArray(new Long[0]))
                        .map(this::getProduitById)
                        .toArray(ProduitDto[]::new);
                commande.setProduits(produits);
            }
        }

        return commandes;
    }
}
