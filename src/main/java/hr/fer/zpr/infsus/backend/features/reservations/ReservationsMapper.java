package hr.fer.zpr.infsus.backend.features.reservations;

import hr.fer.zpr.infsus.backend.features.reservations.data.Reservation;
import hr.fer.zpr.infsus.backend.features.reservations.data.ReservationDTO;

public class ReservationsMapper {

    public static Reservation toEntity(ReservationDTO dto) {
        return Reservation.builder()
                .reservationId(dto.getReservationId())
                .roomId(dto.getRoomId())
                .clientId(dto.getClientId())
                .reservationDateFrom(dto.getReservationDateFrom())
                .reservationDateTo(dto.getReservationDateTo())
                .reservationStatusId(dto.getReservationStatusId())
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
