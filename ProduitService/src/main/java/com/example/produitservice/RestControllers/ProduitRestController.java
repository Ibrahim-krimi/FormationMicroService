package com.example.produitservice.RestControllers;

import com.example.produitservice.entites.Produit;
import com.example.produitservice.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProduitRestController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduit(@PathVariable Long id) {
        return ResponseEntity.ok(produitService.getProduit(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Produit>> getProduits() {
        return ResponseEntity.ok(produitService.getProduits());
    }

    @PostMapping("/passCommande")
    public ResponseEntity<Map<String, Object>> passeruneCommande(@RequestBody Produit[] produit) {
        return ResponseEntity.ok(this.produitService.passeruneCommandeProduit(produit));
    }

    @GetMapping("/favicon.ico")
    public Resource favicon() {
        return new ClassPathResource("/static/favicon.ico");
    }
}

