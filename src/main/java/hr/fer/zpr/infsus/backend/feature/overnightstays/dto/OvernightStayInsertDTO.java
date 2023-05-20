package hr.fer.zpr.infsus.backend.feature.overnightstays.dto;

import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientInsert;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class OvernightStayInsertDTO {
    ClientInsert clientInsert;
    Long roomId;
    Date overnightStayDateFrom;
    Date overnightStayDateTo;
}
