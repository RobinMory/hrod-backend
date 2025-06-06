package com.hrod.service;

import com.hrod.dto.ClientDTO;
import com.hrod.dto.ProduitDTO;
import com.hrod.model.Client;
import com.hrod.model.Produit;
import com.hrod.repository.ClientRepository;
import com.hrod.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository repository;
    private final ClientRepository clientRepository;

    public ProduitService(ProduitRepository repository, ClientRepository clientRepository) {
        this.repository = repository;
        this.clientRepository = clientRepository;
    }

    public List<ProduitDTO> getAllProduits() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public ProduitDTO createProduit(ProduitDTO dto) {
        Produit produit = fromDTO(dto);
        return toDTO(repository.save(produit));
    }

    // --- Mapping ---
    private ProduitDTO toDTO(Produit produit) {
        return new ProduitDTO(produit.getId(), produit.getNom(), produit.getPrix(), produit.getStock(),  produit.getClient().getId());
    }

    private Produit fromDTO(ProduitDTO dto) {
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        return new Produit(dto.getId(), dto.getNom(), dto.getPrix(), dto.getStock(), client);
    }
}
