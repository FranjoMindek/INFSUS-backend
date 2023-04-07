package hr.fer.zpr.infsus.backend.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OvernightStay {
    Long overnightStayId;
    Long clientId;
    Long roomId;
    Date overnightStayDateFrom;
    Date overnightStayDateTo;
    String overnightStayStatusId;
}
