package hr.fer.zpr.infsus.backend.feature.overnightstays.dto;

import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientInsertDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class OvernightStayInsertDTO {
    ClientInsertDTO clientInsert;
    Long roomId;
    Date overnightStayDateFrom;
    Date overnightStayDateTo;
}
