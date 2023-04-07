package hr.fer.zpr.infsus.backend.controller;

import hr.fer.zpr.infsus.backend.model.Reservation;
import hr.fer.zpr.infsus.backend.model.ReservationInsert;
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
    public List<Reservation> getReservations() {
        return this.reservationService.getReservations();
    }

    @GetMapping("/reservations/{reservationId}")
    public Reservation getReservationById(@PathVariable Long reservationId) {
        return this.reservationService.getReservationById(reservationId);
    }

    @PostMapping("/reservations")
    public boolean insertReservation(@RequestBody ReservationInsert reservationInsert) {
        return this.reservationService.insertReservation(reservationInsert);
    }

    @PutMapping("/reservations/{reservationId}")
    public boolean updateReservation(@PathVariable Long reservationId,
                              @RequestBody Reservation reservation) {
        return this.reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/reservations/{reservationId}")
    public boolean deleteReservation(@PathVariable Long reservationId) {
        return this.reservationService.deleteReservation(reservationId);
    }
}
