package hr.fer.zpr.infsus.backend.features.overnightstays.data;

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
