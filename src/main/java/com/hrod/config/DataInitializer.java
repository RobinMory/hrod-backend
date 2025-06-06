package com.hrod.config;

import com.hrod.model.Client;
import com.hrod.model.Produit;
import com.hrod.repository.ClientRepository;
import com.hrod.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(ProduitRepository produitRepository, ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client("Robin", "robin@test.com", "0479", new ArrayList<>()));
            Client robin = clientRepository.findAll().get(0);

            produitRepository.save(new Produit("Chaise", new BigDecimal("24.99"), 10, robin));
            produitRepository.save(new Produit("Table", new BigDecimal("89.90"), 5, robin));
        };
    }
}
