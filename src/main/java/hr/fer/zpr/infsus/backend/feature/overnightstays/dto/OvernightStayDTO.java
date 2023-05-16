package hr.fer.zpr.infsus.backend.feature.overnightstays.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class OvernightStayDTO {
    Long overnightStayId;
    Long clientId;
    Long roomId;
    Date overnightStayDateFrom;
    Date overnightStayDateTo;
    String overnightStayStatusId;
}
