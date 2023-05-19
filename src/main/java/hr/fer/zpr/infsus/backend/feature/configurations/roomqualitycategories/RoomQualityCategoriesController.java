package hr.fer.zpr.infsus.backend.feature.configurations.roomqualitycategories;

import hr.fer.zpr.infsus.backend.feature.codebooks.data.Codebook;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomQualityCategoriesController {

    private final RoomQualityCategoriesService roomQualityCategoriesService;

    @GetMapping("/room-quality-categories")
    public ResponseEntity<List<Codebook>> getRoomQualityCategories() {
        return ResponseEntity.ok(this.roomQualityCategoriesService.getRoomQualityCategories());
    }

    // client decides the id
    @PutMapping("/room-quality-categories/{id}")
    public ResponseEntity<?> insertRoomQualityCategory(
            @PathVariable String id,
            @RequestBody Codebook roomQualityCategory) {
        this.roomQualityCategoriesService.insertRoomQualityCategory(roomQualityCategory);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/room-quality-categories/{id}")
    public ResponseEntity<?> deleteRoomQualityCategory(@PathVariable String id) {
        if (this.roomQualityCategoriesService.deleteRoomQualityCategory(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
