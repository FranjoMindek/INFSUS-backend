package hr.fer.zpr.infsus.backend.controller;

import hr.fer.zpr.infsus.backend.model.OvernightStay;
import hr.fer.zpr.infsus.backend.model.Reservation;
import hr.fer.zpr.infsus.backend.repository.OvernightStayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OvernightStaysController {

    private final OvernightStayRepository overnightStayRepository;

    @GetMapping("/overnight-stays")
    public List<OvernightStay> getRooms() {
        return this.overnightStayRepository.getOvernightStays();
    }

    @GetMapping("/overnight-stays/{overnightStaysId}")
    public OvernightStay getRoomById(@PathVariable Long overnightStaysId) {
        return this.overnightStayRepository.getOvernightStayById(overnightStaysId);
    }

    @PutMapping("/overnight-stays/{overnightStaysId}")
    public boolean updateRoom(@PathVariable Long overnightStaysId,
                              @RequestBody OvernightStay overnightStay) {
        return this.overnightStayRepository.updateOvernightStay(overnightStay);
    }

    @DeleteMapping("/overnight-stays/{overnightStaysId}")
    public boolean deleteRoom(@PathVariable Long overnightStaysId) {
        return this.overnightStayRepository.deleteOvernightStay(overnightStaysId);
    }
}
