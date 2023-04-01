package hr.fer.zpr.infsus.backend.controller;

import hr.fer.zpr.infsus.backend.model.OvernightStay;
import hr.fer.zpr.infsus.backend.service.OvernightStayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OvernightStaysController {

    private final OvernightStayService overnightStayService;

    @GetMapping("/overnight-stays")
    public List<OvernightStay> getOvernightStays() {
        return this.overnightStayService.getOvernightStays();
    }

    @GetMapping("/overnight-stays/{overnightStaysId}")
    public OvernightStay getOvernightStayById(@PathVariable Long overnightStaysId) {
        return this.overnightStayService.getOvernightStayById(overnightStaysId);
    }

    @PostMapping("/overnight-stays")
    public boolean insertOvernightStay(@RequestBody OvernightStay overnightStay) {
        return this.overnightStayService.insertOvernightStay(overnightStay);
    }

    @PutMapping("/overnight-stays/{overnightStaysId}")
    public boolean updateOvernightStay(@PathVariable Long overnightStaysId,
                              @RequestBody OvernightStay overnightStay) {
        return this.overnightStayService.updateOvernightStay(overnightStay);
    }

    @DeleteMapping("/overnight-stays/{overnightStaysId}")
    public boolean deleteOvernightStay(@PathVariable Long overnightStaysId) {
        return this.overnightStayService.deleteOvernightStay(overnightStaysId);
    }
}
