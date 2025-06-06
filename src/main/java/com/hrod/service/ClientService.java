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
public class ClientService {

    private final ClientRepository repository;
    private final ProduitRepository produitRepository;

    public ClientService(ClientRepository repository, ProduitRepository produitRepository) {
        this.repository = repository;
        this.produitRepository = produitRepository;
    }

    public List<ClientDTO> getAllClients() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public ClientDTO getClientById(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return toDTO(client);
    }

    public ClientDTO createClient(ClientDTO dto) {
        Client client = fromDTO(dto);
        return toDTO(repository.save(client));
    }

    private ProduitDTO toProduitDTO(Produit produit) {
        return new ProduitDTO(produit.getId(), produit.getNom(), produit.getPrix(), produit.getStock(),
                produit.getClient() != null ? produit.getClient().getId() : null
        );
    }

    // --- Mapping ---
    private ClientDTO toDTO(Client client) {
        List<ProduitDTO> produits = produitRepository.findByClient(client).stream()
                .map(this::toProduitDTO)
                .toList();
        return new ClientDTO(client.getId(), client.getNom(), client.getEmail(), client.getTelephone(),produits);
    }

    private Client fromDTO(ClientDTO dto) {
        return new Client(dto.getId(), dto.getNom(), dto.getEmail(), dto.getTelephone(),null);
    }
}

