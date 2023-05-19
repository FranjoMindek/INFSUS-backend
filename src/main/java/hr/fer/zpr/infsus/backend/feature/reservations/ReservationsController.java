package hr.fer.zpr.infsus.backend.feature.reservations;

import hr.fer.zpr.infsus.backend.feature.reservations.dto.ReservationDTO;
import hr.fer.zpr.infsus.backend.feature.reservations.dto.ReservationInsertDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReservationsController {

    private final ReservationsService reservationsService;

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDTO>> getReservations() {
        return ResponseEntity.ok(this.reservationsService.getReservations());
    }

    @GetMapping("/reservations/{reservationId}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long reservationId) {
        ReservationDTO dto = this.reservationsService.getReservationById(reservationId);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/reservations")
    public ResponseEntity<?> insertReservation(@RequestBody ReservationInsertDTO reservationInsert) {
        Long id = this.reservationsService.insertReservation(reservationInsert);
        return ResponseEntity.created(URI.create("api/reservations/" + id)).build();
    }

    @PutMapping("/reservations/{reservationId}")
    public ResponseEntity<?> updateReservation(@PathVariable Long reservationId,
                                                    @RequestBody ReservationDTO reservation) {
        if (this.reservationsService.updateReservation(reservation)) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/reservations/{reservationId}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long reservationId) {
        if (this.reservationsService.deleteReservation(reservationId)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
