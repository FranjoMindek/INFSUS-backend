package hr.fer.zpr.infsus.backend.feature.clients.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    Long clientId;
    String clientNationalId;
    String clientPhoneNumber;
    String clientFirstName;
    String clientLastName;
}
