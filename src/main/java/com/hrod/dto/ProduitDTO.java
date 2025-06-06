package com.hrod.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDTO {
    private Long id;
    private String nom;
    private BigDecimal prix;
    private Integer stock;
    private Long clientId;
}
