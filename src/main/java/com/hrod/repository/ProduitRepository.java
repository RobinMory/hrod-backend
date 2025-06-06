package com.hrod.repository;

import com.hrod.model.Client;
import com.hrod.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByClient(Client client);
    // Tu peux ajouter des méthodes personnalisées ici plus tard
}