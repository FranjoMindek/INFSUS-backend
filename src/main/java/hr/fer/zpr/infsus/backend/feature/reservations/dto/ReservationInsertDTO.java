package hr.fer.zpr.infsus.backend.feature.reservations.dto;

import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientInsertDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class ReservationInsertDTO {
    ClientInsertDTO clientInsertDTO;
    Long roomId;
    Date reservationDateFrom;
    Date reservationDateTo;
}
