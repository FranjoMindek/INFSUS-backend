package hr.fer.zpr.infsus.backend.feature.clients;

import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientDTO;
import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientInsertDTO;
import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientUpdateDTO;
import hr.fer.zpr.infsus.backend.feature.clients.model.Client;

public class ClientsMapper {

    public static Client toEntity(ClientDTO dto) {
        return Client.builder()
                .clientId(dto.getClientId())
                .clientNationalId(dto.getClientNationalId())
                .clientPhoneNumber(dto.getClientPhoneNumber())
                .clientFirstName(dto.getClientFirstName())
                .clientLastName(dto.getClientLastName())
                .build();
    }

    public static Client toEntity(ClientInsertDTO dto) {
        return Client.builder()
                .clientNationalId(dto.getClientNationalId())
                .clientPhoneNumber(dto.getClientPhoneNumber())
                .clientFirstName(dto.getClientFirstName())
                .clientLastName(dto.getClientLastName())
                .build();
    }

    public static ClientDTO toDTO(Client entity) {
        ClientDTO dto = new ClientDTO();
        dto.setClientId(entity.getClientId());
        dto.setClientNationalId(entity.getClientNationalId());
        dto.setClientPhoneNumber(entity.getClientPhoneNumber());
        dto.setClientFirstName(entity.getClientFirstName());
        dto.setClientLastName(entity.getClientLastName());
        return dto;
    }

    public static Client toEntity(ClientUpdateDTO dto) {
        return Client.builder()
                .clientId(dto.getClientId())
                .clientFirstName(dto.getClientFirstName())
                .clientLastName(dto.getClientLastName())
                .clientPhoneNumber(dto.getClientPhoneNumber())
                .build();
    }
}
