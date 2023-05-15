package hr.fer.zpr.infsus.backend.features.clients.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Client {
    Long clientId;
    String clientNationalId;
    String clientPhoneNumber;
    String clientFirstName;
    String clientLastName;
}
