package hr.fer.zpr.infsus.backend.feature.reservations;

import hr.fer.zpr.infsus.backend.feature.clients.ClientsService;
import hr.fer.zpr.infsus.backend.feature.reservations.dto.ReservationDTO;
import hr.fer.zpr.infsus.backend.feature.reservations.dto.ReservationInsertDTO;
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

    public Long insertReservation(ReservationInsertDTO reservationInsertDTO) {
        Long clientId = this.clientsService.insertClientIfNew(reservationInsertDTO.getClientInsertDTO());

        return this.reservationsRepository.insertReservation(
                ReservationsMapper.toEntity(reservationInsertDTO, clientId));
    }

    public boolean updateReservation(ReservationDTO reservationDTO) {
        return this.reservationsRepository.updateReservation(ReservationsMapper.toEntity(reservationDTO));
    }

    public boolean deleteReservation(Long reservationId) {
        return this.reservationsRepository.deleteReservation(reservationId);
    }
}
