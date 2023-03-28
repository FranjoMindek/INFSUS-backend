package hr.fer.zpr.infsus.backend.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Client {
    Long clientId;
    String clientFirstName;
    String clientLastName;
}
