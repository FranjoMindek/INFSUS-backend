package hr.fer.zpr.infsus.backend.feature.clients;

import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientDTO;
import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientInsert;
import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientUpdateDTO;
import hr.fer.zpr.infsus.backend.feature.clients.model.Client;
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

    public Long insertClientIfNew(ClientInsert clientInsert) {
        Client oldClient = this.clientsRepository.getClientByNationalId(clientInsert.getClientNationalId());
        if (oldClient == null) {
            return this.insertClient(clientInsert);
        } else {
            return oldClient.getClientId();
        }
    }

    public Long insertClient(ClientInsert clientInsert) {
        return this.clientsRepository.insertClient(ClientsMapper.toEntity(clientInsert));
    }

    public boolean updateClient(ClientUpdateDTO clientDTO) {
        return this.clientsRepository.updateClient(ClientsMapper.toEntity(clientDTO));
    }

    public boolean deleteClient(Long clientId) {
        return this.clientsRepository.deleteClient(clientId);
    }
}
