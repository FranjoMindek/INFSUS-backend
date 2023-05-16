package hr.fer.zpr.infsus.backend.feature.overnightstays;

import hr.fer.zpr.infsus.backend.feature.overnightstays.dto.OvernightStayDTO;
import hr.fer.zpr.infsus.backend.feature.overnightstays.dto.OvernightStayInsertDTO;
import hr.fer.zpr.infsus.backend.feature.overnightstays.model.OvernightStay;

public class OvernightStaysMapper {

    public static OvernightStay toEntity(OvernightStayDTO dto) {
        OvernightStay entity = new OvernightStay();
        entity.setOvernightStayId(dto.getOvernightStayId());
        entity.setClientId(dto.getClientId());
        entity.setRoomId(dto.getRoomId());
        entity.setOvernightStayDateFrom(dto.getOvernightStayDateFrom());
        entity.setOvernightStayDateTo(dto.getOvernightStayDateTo());
        entity.setOvernightStayStatusId(dto.getOvernightStayStatusId());
        return entity;
    }

    public static OvernightStay toEntity(OvernightStayInsertDTO dto, Long clientId) {
        return OvernightStay.builder()
                .clientId(clientId)
                .roomId(dto.getRoomId())
                .overnightStayDateFrom(dto.getOvernightStayDateFrom())
                .overnightStayDateTo(dto.getOvernightStayDateTo())
                .build();
    }

    public static OvernightStayDTO toDTO(OvernightStay entity) {
        OvernightStayDTO dto = new OvernightStayDTO();
        dto.setOvernightStayId(entity.getOvernightStayId());
        dto.setClientId(entity.getClientId());
        dto.setRoomId(entity.getRoomId());
        dto.setOvernightStayDateFrom(entity.getOvernightStayDateFrom());
        dto.setOvernightStayDateTo(entity.getOvernightStayDateTo());
        dto.setOvernightStayStatusId(entity.getOvernightStayStatusId());
        return dto;
    }
}
