package com.hrod.controller;

import com.hrod.dto.ProduitDTO;
import com.hrod.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProduitDTO> getProduits() {
        return service.getAllProduits();
    }

    @PostMapping
    public ProduitDTO addProduit(@RequestBody ProduitDTO produit) {
        return service.createProduit(produit);
    }
}
