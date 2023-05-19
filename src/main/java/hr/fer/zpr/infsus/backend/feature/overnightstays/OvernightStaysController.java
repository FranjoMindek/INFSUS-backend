package hr.fer.zpr.infsus.backend.feature.overnightstays;

import hr.fer.zpr.infsus.backend.feature.overnightstays.dto.OvernightStayDTO;
import hr.fer.zpr.infsus.backend.feature.overnightstays.dto.OvernightStayInsertDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OvernightStaysController {

    private final OvernightStaysService overnightStaysService;

    @GetMapping("/overnight-stays")
    public ResponseEntity<List<OvernightStayDTO>> getOvernightStays() {
        return ResponseEntity.ok(this.overnightStaysService.getOvernightStays());
    }

    @GetMapping("/overnight-stays/{id}")
    public ResponseEntity<OvernightStayDTO> getOvernightStayById(@PathVariable Long id) {
        OvernightStayDTO dto = this.overnightStaysService.getOvernightStayById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/overnight-stays")
    public ResponseEntity<?> insertOvernightStay(@RequestBody OvernightStayInsertDTO overnightStayInsertDTO) {
        Long id = this.overnightStaysService.insertOvernightStay(overnightStayInsertDTO);
        return ResponseEntity.created(URI.create("api/overnight-stays/" + id)).build();
    }

    @PutMapping("/overnight-stays/{id}")
    public ResponseEntity<?> updateOvernightStay(@PathVariable Long id,
                              @RequestBody OvernightStayDTO overnightStayDTO) {
        if (this.overnightStaysService.updateOvernightStay(overnightStayDTO)) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/overnight-stays/{overnightStaysId}")
    public ResponseEntity<?> deleteOvernightStay(@PathVariable Long overnightStaysId) {
        if (this.overnightStaysService.deleteOvernightStay(overnightStaysId)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
