package hr.fer.zpr.infsus.backend.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReservationInsert {
    String clientNationalId;
    String clientFirstName;
    String clientLastName;
    String clientPhoneNumber;
    Long roomId;
    Date reservationDateFrom;
    Date reservationDateTo;
}
