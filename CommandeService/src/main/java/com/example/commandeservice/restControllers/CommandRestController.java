package com.example.commandeservice.restControllers;


import com.example.commandeservice.entites.Commande;
import com.example.commandeservice.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/command")
public class CommandRestController {

    private final CommandService commandService;
    @Autowired
    public CommandRestController(CommandService commandService) {
        this.commandService = commandService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Commande>> getAllCommandes() {
        return ResponseEntity.ok(this.commandService.getCommandes());
    }

    @GetMapping("/allwithproduct")
    public ResponseEntity<List<Commande>> getAllCommandesWithProduct() {
        return ResponseEntity.ok(this.commandService.getCommandesWithProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeWith(@PathVariable Long id) {
        return ResponseEntity.ok(this.commandService.getCommande(id));
    }



}
