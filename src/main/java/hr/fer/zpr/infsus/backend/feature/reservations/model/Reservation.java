package hr.fer.zpr.infsus.backend.feature.reservations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    Long reservationId;
    Long clientId;
    Long roomId;
    Date reservationDateFrom;
    Date reservationDateTo;
    String reservationStatusId;
}
