package com.hrod.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private BigDecimal prix;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Produit(String nom, BigDecimal prix, Integer stock, Client client) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
        this.client = client;
    }
}

