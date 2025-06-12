package com.hrod.controller;

import com.hrod.dto.ProduitDTO;
import com.hrod.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService service) {
        this.produitService = service;
    }

    @GetMapping
    public List<ProduitDTO> getProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/client/{clientId}")
    public List<ProduitDTO> getProduitsByClient(@PathVariable Long clientId) {
        return produitService.getProduitsByClientId(clientId);
    }


    @PostMapping
    public ProduitDTO addProduit(@RequestBody ProduitDTO produit) {
        return produitService.createProduit(produit);
    }
}
