package hr.fer.zpr.infsus.backend.feature.clients;

import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientDTO;
import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientInsertDTO;
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

    public Long insertClientIfNew(ClientInsertDTO clientInsertDTO) {
        Client oldClient = this.clientsRepository.getClientByNationalId(clientInsertDTO.getClientNationalId());
        if (oldClient != null) {
            return this.insertClient(clientInsertDTO);
        } else {
            return oldClient.getClientId();
        }
    }

    public Long insertClient(ClientInsertDTO clientInsertDTO) {
        return this.clientsRepository.insertClient(ClientsMapper.toEntity(clientInsertDTO));
    }

    public boolean updateClient(ClientDTO clientDTO) {
        return this.clientsRepository.updateClient(ClientsMapper.toEntity(clientDTO));
    }

    public boolean deleteClient(Long clientId) {
        return this.clientsRepository.deleteClient(clientId);
    }
}
