package hr.fer.zpr.infsus.backend.feature.overnightstays;

import hr.fer.zpr.infsus.backend.feature.overnightstays.data.OvernightStayDTO;
import hr.fer.zpr.infsus.backend.feature.overnightstays.data.OvernightStayInsertDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OvernightStaysController {

    private final OvernightStaysService overnightStaysService;

    @GetMapping("/overnight-stays")
    public List<OvernightStayDTO> getOvernightStays() {
        return this.overnightStaysService.getOvernightStays();
    }

    @GetMapping("/overnight-stays/{overnightStaysId}")
    public OvernightStayDTO getOvernightStayById(@PathVariable Long overnightStaysId) {
        return this.overnightStaysService.getOvernightStayById(overnightStaysId);
    }

    @PostMapping("/overnight-stays")
    public boolean insertOvernightStay(@RequestBody OvernightStayInsertDTO overnightStayInsertDTO) {
        return this.overnightStaysService.insertOvernightStay(overnightStayInsertDTO);
    }

    @PutMapping("/overnight-stays/{overnightStaysId}")
    public boolean updateOvernightStay(@PathVariable Long overnightStaysId,
                              @RequestBody OvernightStayDTO overnightStayDTO) {
        return this.overnightStaysService.updateOvernightStay(overnightStayDTO);
    }

    @DeleteMapping("/overnight-stays/{overnightStaysId}")
    public boolean deleteOvernightStay(@PathVariable Long overnightStaysId) {
        return this.overnightStaysService.deleteOvernightStay(overnightStaysId);
    }
}
