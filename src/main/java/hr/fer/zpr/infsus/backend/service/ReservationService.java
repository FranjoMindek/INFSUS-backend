package hr.fer.zpr.infsus.backend.service;

import hr.fer.zpr.infsus.backend.model.Reservation;
import hr.fer.zpr.infsus.backend.model.ReservationInsert;
import hr.fer.zpr.infsus.backend.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ClientService clientService;

    public List<Reservation> getReservations() {
        return this.reservationRepository.getReservations();
    }

    public Reservation getReservationById(Long reservationId) {
        return this.reservationRepository.getReservationById(reservationId);
    }

    public boolean insertReservation(ReservationInsert reservationInsert) {
        Long clientId = this.clientService.insertClientIfNew(reservationInsert);
        return this.reservationRepository.insertReservation(reservationInsert, clientId);
    }

    public boolean updateReservation(Reservation reservation) {
        return this.reservationRepository.updateReservation(reservation);
    }

    public boolean deleteReservation(Long reservationId) {
        return this.reservationRepository.deleteReservation(reservationId);
    }
}
