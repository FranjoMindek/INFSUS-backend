package hr.fer.zpr.infsus.backend.features.reservations.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class ReservationDTO {
    Long reservationId;
    Long clientId;
    Long roomId;
    Date reservationDateFrom;
    Date reservationDateTo;
    String reservationStatusId;
}
