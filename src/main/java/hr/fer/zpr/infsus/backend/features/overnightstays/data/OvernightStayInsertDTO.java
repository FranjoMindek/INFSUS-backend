package hr.fer.zpr.infsus.backend.features.overnightstays.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class OvernightStayInsertDTO {
    String clientNationalId;
    String clientFirstName;
    String clientLastName;
    String clientPhoneNumber;
    Long roomId;
    Date overnightStayDateFrom;
    Date overnightStayDateTo;
}
