package hr.fer.zpr.infsus.backend.features.reservations.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class ReservationInsertDTO {
//    ClientDTO clientDTO;
//    ReservationDTO reservationDTO;
    Long roomId;
    Date reservationDateFrom;
    Date reservationDateTo;
    String clientNationalId;
    String clientPhoneNumber;
    String clientFirstName;
    String clientLastName;
}
