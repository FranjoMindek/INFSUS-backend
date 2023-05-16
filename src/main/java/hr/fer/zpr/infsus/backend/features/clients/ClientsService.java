package hr.fer.zpr.infsus.backend.features.clients;

import hr.fer.zpr.infsus.backend.features.clients.data.Client;
import hr.fer.zpr.infsus.backend.features.clients.data.ClientDTO;
import hr.fer.zpr.infsus.backend.features.clients.data.ClientsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientsService {

    private final ClientsRepository clientsRepository;

    public List<ClientDTO> getClients() { return this.clientsRepository.getClients().stream()
            .map(ClientsMapper::toDTO)
            .toList(); }
    public ClientDTO getClientById(Long clientId) {
        return ClientsMapper.toDTO(this.clientsRepository.getClientById(clientId));
    }

    public ClientDTO getClientByNationalId(String clientNationalId) {
        return ClientsMapper.toDTO(this.clientsRepository.getClientByNationalId(clientNationalId));
    }

    public Long insertClientIfNew(Client client) {
        Client oldClient = this.clientsRepository.getClientByNationalId(client.getClientNationalId());
        if (oldClient != null) {
            return this.clientsRepository.insertClient(client);
        } else {
            return oldClient.getClientId();
        }
    }

    public Long insertClient(ClientDTO clientDTO) {
        return this.clientsRepository.insertClient(ClientsMapper.toEntity(clientDTO));
    }

    public boolean updateClient(ClientDTO clientDTO) {
        return this.clientsRepository.updateClient(ClientsMapper.toEntity(clientDTO));
    }

    public boolean deleteClient(Long clientId) {
        return this.clientsRepository.deleteClient(clientId);
    }
}
