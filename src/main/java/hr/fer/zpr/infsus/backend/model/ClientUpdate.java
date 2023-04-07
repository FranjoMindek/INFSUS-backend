package hr.fer.zpr.infsus.backend.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClientUpdate {
    Long clientId;
    String clientFirstName;
    String clientLastName;
    String clientPhoneNumber;
}
