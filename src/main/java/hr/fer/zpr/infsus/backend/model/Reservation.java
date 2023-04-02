package hr.fer.zpr.infsus.backend.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Reservation {
    Long reservationId;
    Long clientId;
    Long roomId;
    Date reservationDateFrom;
    Date reservationDateTo;
    String reservationStatusId;
}
