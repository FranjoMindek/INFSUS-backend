package hr.fer.zpr.infsus.backend.feature.overnightstays;

import hr.fer.zpr.infsus.backend.feature.overnightstays.dto.OvernightStayDTO;
import hr.fer.zpr.infsus.backend.feature.overnightstays.dto.OvernightStayInsertDTO;
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

    @GetMapping("/overnight-stays/{id}")
    public OvernightStayDTO getOvernightStayById(@PathVariable Long id) {
        return this.overnightStaysService.getOvernightStayById(id);
    }

    @PostMapping("/overnight-stays")
    public boolean insertOvernightStay(@RequestBody OvernightStayInsertDTO overnightStayInsertDTO) {
        return this.overnightStaysService.insertOvernightStay(overnightStayInsertDTO);
    }

    @PutMapping("/overnight-stays/{id}")
    public boolean updateOvernightStay(@PathVariable Long id,
                              @RequestBody OvernightStayDTO overnightStayDTO) {
        return this.overnightStaysService.updateOvernightStay(overnightStayDTO);
    }

    @DeleteMapping("/overnight-stays/{overnightStaysId}")
    public boolean deleteOvernightStay(@PathVariable Long overnightStaysId) {
        return this.overnightStaysService.deleteOvernightStay(overnightStaysId);
    }
}
