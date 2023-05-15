package hr.fer.zpr.infsus.backend.features.overnightstays;

import hr.fer.zpr.infsus.backend.features.overnightstays.data.OvernightStay;
import hr.fer.zpr.infsus.backend.features.overnightstays.data.OvernightStayDTO;

public class OvernightStaysMapper {

    public static OvernightStay toEntity(OvernightStayDTO dto) {
        return OvernightStay.builder()
                .overnightStayId(dto.getOvernightStayId())
                .clientId(dto.getClientId())
                .roomId(dto.getRoomId())
                .overnightStayDateFrom(dto.getOvernightStayDateFrom())
                .overnightStayDateTo(dto.getOvernightStayDateTo())
                .overnightStayStatusId(dto.getOvernightStayStatusId())
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
