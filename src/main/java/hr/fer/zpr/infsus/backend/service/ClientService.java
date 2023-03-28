package hr.fer.zpr.infsus.backend.service;

import hr.fer.zpr.infsus.backend.model.Client;
import hr.fer.zpr.infsus.backend.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getClients() {
        return this.clientRepository.getClients();
    }

    public Client getClientById(Long clientId) {
        return this.clientRepository.getClientById(clientId);
    }

    public boolean updateClient(Client client) {
        return this.clientRepository.updateClient(client);
    }

    public boolean deleteClient(Long clientId) {
        return this.clientRepository.deleteClient(clientId);
    }
}
