package hr.fer.zpr.infsus.backend.features.reservations;

import hr.fer.zpr.infsus.backend.features.reservations.data.ReservationDTO;
import hr.fer.zpr.infsus.backend.features.reservations.data.ReservationInsertDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReservationsController {

    private final ReservationsService reservationsService;

    @GetMapping("/reservations")
    public List<ReservationDTO> getReservations() {
        return this.reservationsService.getReservations();
    }

    @GetMapping("/reservations/{reservationId}")
    public ReservationDTO getReservationById(@PathVariable Long reservationId) {
        return this.reservationsService.getReservationById(reservationId);
    }

    @PostMapping("/reservations")
    public boolean insertReservation(@RequestBody ReservationInsertDTO reservationInsert) {
        return this.reservationsService.insertReservation(reservationInsert);
    }

    @PutMapping("/reservations/{reservationId}")
    public boolean updateReservation(@PathVariable Long reservationId,
                              @RequestBody ReservationDTO reservation) {
        return this.reservationsService.updateReservation(reservation);
    }

    @DeleteMapping("/reservations/{reservationId}")
    public boolean deleteReservation(@PathVariable Long reservationId) {
        return this.reservationsService.deleteReservation(reservationId);
    }
}
