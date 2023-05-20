package hr.fer.zpr.infsus.backend.feature.clients.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ClientUpdateDTO {
    Long clientId;
    String clientPhoneNumber;
    String clientFirstName;
    String clientLastName;
}
