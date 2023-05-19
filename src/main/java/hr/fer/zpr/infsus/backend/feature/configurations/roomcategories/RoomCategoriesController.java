package hr.fer.zpr.infsus.backend.feature.configurations.roomcategories;

import hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.dto.RoomCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomCategoriesController {
    private final RoomCategoriesService roomCategoriesService;

    @GetMapping("/room-categories")
    public ResponseEntity<List<RoomCategoryDTO>> getRoomCategories() {
        return ResponseEntity.ok(this.roomCategoriesService.getRoomCategories());
    }

    // client decides the id -> update or insert??? merge?
    @PutMapping("/room-categories/{id}")
    public ResponseEntity<?> insertRoomCategory(
            @PathVariable String id,
            @RequestBody RoomCategoryDTO roomCategory) {
        this.roomCategoriesService.insertUpdateCategory(roomCategory); // will succeed on either update or insert
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/room-categories/{id}")
    public ResponseEntity<?> deleteRoomCategory(@PathVariable String id) {
        if (this.roomCategoriesService.deleteRoomCategory(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
