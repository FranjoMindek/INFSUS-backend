package hr.fer.zpr.infsus.backend.features.clients.data;

public class ClientsMapper {

    public static Client toEntity(ClientDTO dto) {
        Client entity = new Client();
        entity.setClientId(dto.getClientId());
        entity.setClientNationalId(dto.getClientNationalId());
        entity.setClientPhoneNumber(dto.getClientPhoneNumber());
        entity.setClientFirstName(dto.getClientFirstName());
        entity.setClientLastName(dto.getClientLastName());
        return entity;
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
