package hr.fer.zpr.infsus.backend.feature.clients.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ClientDTO {
    Long clientId;
    String clientNationalId;
    String clientPhoneNumber;
    String clientFirstName;
    String clientLastName;
}
