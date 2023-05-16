package hr.fer.zpr.infsus.backend.feature.reservations;

import hr.fer.zpr.infsus.backend.feature.reservations.dto.ReservationDTO;
import hr.fer.zpr.infsus.backend.feature.reservations.dto.ReservationInsertDTO;
import hr.fer.zpr.infsus.backend.feature.reservations.model.Reservation;

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

    public static Reservation toEntity(ReservationInsertDTO dto, Long clientId) {
        return Reservation.builder()
                .clientId(clientId)
                .roomId(dto.getRoomId())
                .reservationDateFrom(dto.getReservationDateFrom())
                .reservationDateTo(dto.getReservationDateTo())
                .build();
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
