package hr.fer.zpr.infsus.backend.features.reservations.data;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class Reservation {
    Long reservationId;
    Long clientId;
    Long roomId;
    Date reservationDateFrom;
    Date reservationDateTo;
    String reservationStatusId;
}
