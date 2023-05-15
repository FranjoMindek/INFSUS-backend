package hr.fer.zpr.infsus.backend.features.clients;

import hr.fer.zpr.infsus.backend.features.clients.data.Client;
import hr.fer.zpr.infsus.backend.features.clients.data.ClientDTO;

public class ClientsMapper {

    public static Client toEntity(ClientDTO dto) {
        return Client.builder()
                .clientId(dto.getClientId())
                .clientNationalId(dto.getClientNationalId())
                .clientFirstName(dto.getClientFirstName())
                .clientLastName(dto.getClientLastName())
                .clientPhoneNumber(dto.getClientPhoneNumber())
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
}
