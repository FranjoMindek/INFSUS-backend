package hr.fer.zpr.infsus.backend.controller;

import hr.fer.zpr.infsus.backend.model.Reservation;
import hr.fer.zpr.infsus.backend.model.Room;
import hr.fer.zpr.infsus.backend.model.agergate.RoomDetailed;
import hr.fer.zpr.infsus.backend.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReservationsController {

    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public List<Reservation> getRooms() {
        return this.reservationService.getReservations();
    }

    @GetMapping("/reservations/{reservationId}")
    public Reservation getRoomById(@PathVariable Long reservationId) {
        return this.reservationService.getReservationById(reservationId);
    }

    @PutMapping("/reservations/{reservationId}")
    public boolean updateRoom(@PathVariable Long reservationId,
                              @RequestBody Reservation reservation) {
        return this.reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/reservations/{reservationId}")
    public boolean deleteRoom(@PathVariable Long reservationId) {
        return this.reservationService.deleteReservation(reservationId);
    }
}
