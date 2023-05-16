package hr.fer.zpr.infsus.backend.feature.configurations.roombedcategories;

import hr.fer.zpr.infsus.backend.feature.codebooks.data.Codebook;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomBedCategoriesController {
    private final RoomBedCategoriesService roomBedCategoriesService;

    @GetMapping("/room-bed-categories")
    public List<Codebook> getRoomBedCategories() {
        return this.roomBedCategoriesService.getRoomBedCategories();
    }

    // client decides the id
    @PutMapping("/room-bed-categories/{id}")
    public boolean insertRoomBedCategory(
            @PathVariable String id, // could technically have DTO which doesn't include id to reduce network traffic
            @RequestBody Codebook roomBedCategory) {
        return this.roomBedCategoriesService.insertRoomBedCategory(roomBedCategory);
    }

    @DeleteMapping("/room-bed-categories/{id}")
    public boolean deleteRoomBedCategory(@PathVariable String id) {
        return this.roomBedCategoriesService.deleteRoomBedCategory(id);
    }
}
