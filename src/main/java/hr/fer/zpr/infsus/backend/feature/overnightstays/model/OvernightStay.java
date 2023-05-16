package hr.fer.zpr.infsus.backend.feature.overnightstays.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OvernightStay {
    Long overnightStayId;
    Long clientId;
    Long roomId;
    Date overnightStayDateFrom;
    Date overnightStayDateTo;
    String overnightStayStatusId;
}
