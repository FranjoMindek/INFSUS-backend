package hr.fer.zpr.infsus.backend.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OvernightStayInsert {
    String clientNationalId;
    String clientFirstName;
    String clientLastName;
    String clientPhoneNumber;
    Long roomId;
    Date overnightStayDateFrom;
    Date overnightStayDateTo;
}
