package com.hrod.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String telephone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Produit> produits;


    public Client(String nom, String email, String telephone, List<Produit> produits) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.produits = produits;
    }
}

