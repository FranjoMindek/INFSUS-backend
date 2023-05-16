package hr.fer.zpr.infsus.backend.features.reservations.data;

public class ReservationsMapper {

    public static Reservation toEntity(ReservationDTO dto) {
        Reservation entity = new Reservation();
        entity.setReservationId(dto.getReservationId());
        entity.setRoomId(dto.getRoomId());
        entity.setClientId(dto.getClientId());
        entity.setReservationDateFrom(dto.getReservationDateFrom());
        entity.setReservationDateTo(dto.getReservationDateTo());
        entity.setReservationStatusId(dto.getReservationStatusId());
        return entity;
    }

    public static ReservationDTO toDTO(Reservation entity) {
        ReservationDTO dto = new ReservationDTO();
        dto.setReservationId(entity.getReservationId());
        dto.setRoomId(entity.getRoomId());
        dto.setClientId(entity.getClientId());
        dto.setReservationDateFrom(entity.getReservationDateFrom());
        dto.setReservationDateTo(entity.getReservationDateTo());
        dto.setReservationStatusId(entity.getReservationStatusId());
        return dto;
    }
}
