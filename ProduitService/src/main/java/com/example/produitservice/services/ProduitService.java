package com.example.produitservice.services;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.produitservice.entites.Produit;
import com.example.produitservice.repo.ProduitRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {
    private ProduitRespository respository;

    @Autowired
    public ProduitService(ProduitRespository produitRepository) {
        this.respository = produitRepository;
    }

    public Produit getProduit(Long id) {
        return this.respository.findById(id).orElse(null);
    }

    public List<Produit> getProduits() {
        return this.respository.findAll();
    }

    public Map<String, Object> passeruneCommandeProduit(Produit[] produits) {
        Map<String, Object> response = new HashMap<>();

        if (produits.length == 0) {
            response.put("message", "Problème : le tableau est vide");
            response.put("status", false);
            return response;
        }

        for (Produit produit : produits) {
            Produit stock = this.respository.findById(produit.getId()).orElse(null);
            if (stock == null) {
                response.put("message", "Stock null pour le produit avec l'id : " + produit.getId());
                response.put("status", false);
                return response;
            }
            if (produit.getQuantite() > stock.getQuantite()) {
                response.put("message", "Problème : la demande est trop élevée pour " + produit.getNom() + ". La quantité disponible est de " + stock.getQuantite());
                response.put("status", false);
                return response;
            }
        }

        for (Produit produit : produits) {
            Produit stock = this.respository.findById(produit.getId()).orElse(null);
            if (stock != null) {
                stock.setQuantite(stock.getQuantite() - produit.getQuantite());
                this.respository.save(stock);
            }
        }

        response.put("message", "Tout est bon");
        response.put("status", true);
        return response;
    }

}
