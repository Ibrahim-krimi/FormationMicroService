package com.example.produitservice.repo;

import com.example.produitservice.entites.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRespository extends JpaRepository<Produit, Long> {

}
