package hr.fer.zpr.infsus.backend.features.overnightstays.data;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class OvernightStay {
    Long overnightStayId;
    Long clientId;
    Long roomId;
    Date overnightStayDateFrom;
    Date overnightStayDateTo;
    String overnightStayStatusId;
}
