package hr.fer.zpr.infsus.backend.features.reservations;

import hr.fer.zpr.infsus.backend.features.clients.ClientsService;
import hr.fer.zpr.infsus.backend.features.clients.data.Client;
import hr.fer.zpr.infsus.backend.features.reservations.data.Reservation;
import hr.fer.zpr.infsus.backend.features.reservations.data.ReservationDTO;
import hr.fer.zpr.infsus.backend.features.reservations.data.ReservationInsertDTO;
import hr.fer.zpr.infsus.backend.features.reservations.data.ReservationsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;
    private final ClientsService clientsService;

    public List<ReservationDTO> getReservations() {
        return this.reservationsRepository.getReservations().stream()
                .map(ReservationsMapper::toDTO)
                .toList();
    }

    public ReservationDTO getReservationById(Long reservationId) {
        return ReservationsMapper.toDTO(this.reservationsRepository.getReservationById(reservationId));
    }

    public boolean insertReservation(ReservationInsertDTO reservationDTO) {
        Long clientId = this.clientsService.insertClientIfNew(
                        Client.builder()
                                .clientNationalId(reservationDTO.getClientNationalId())
                                .clientPhoneNumber(reservationDTO.getClientPhoneNumber())
                                .clientFirstName(reservationDTO.getClientFirstName())
                                .clientLastName(reservationDTO.getClientLastName())
                                .build());

        return this.reservationsRepository.insertReservation(
                Reservation.builder()
                        .clientId(clientId)
                        .roomId(reservationDTO.getRoomId())
                        .reservationDateFrom(reservationDTO.getReservationDateFrom())
                        .reservationDateTo(reservationDTO.getReservationDateTo())
                        .build()
        );
    }

    public boolean updateReservation(ReservationDTO reservationDTO) {
        return this.reservationsRepository.updateReservation(ReservationsMapper.toEntity(reservationDTO));
    }

    public boolean deleteReservation(Long reservationId) {
        return this.reservationsRepository.deleteReservation(reservationId);
    }
}
