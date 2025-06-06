package com.hrod.dto;

import com.hrod.model.Produit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String nom;
    private String email;
    private String telephone;
    private List<ProduitDTO> produits;
}

