package hr.fer.zpr.infsus.backend.feature.configurations.roombedcategories;

import hr.fer.zpr.infsus.backend.feature.codebooks.data.Codebook;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomBedCategoriesController {
    private final RoomBedCategoriesService roomBedCategoriesService;

    @GetMapping("/room-bed-categories")
    public ResponseEntity<List<Codebook>> getRoomBedCategories() {
        return ResponseEntity.ok(this.roomBedCategoriesService.getRoomBedCategories());
    }

    // client decides the id
    @PutMapping("/room-bed-categories/{id}")
    public ResponseEntity<?> insertRoomBedCategory(
            @PathVariable String id,
            @RequestBody Codebook roomBedCategory) {
        this.roomBedCategoriesService.insertRoomBedCategory(roomBedCategory);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/room-bed-categories/{id}")
    public ResponseEntity<?> deleteRoomBedCategory(@PathVariable String id) {
        if (this.roomBedCategoriesService.deleteRoomBedCategory(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
