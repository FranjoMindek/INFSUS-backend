package hr.fer.zpr.infsus.backend.feature.configurations.roomqualitycategories;

import hr.fer.zpr.infsus.backend.feature.codebooks.data.Codebook;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomQualityCategoriesController {

    private final RoomQualityCategoriesService roomQualityCategoriesService;

    @GetMapping("/room-quality-categories")
    public List<Codebook> getRoomQualityCategories() {
        return this.roomQualityCategoriesService.getRoomQualityCategories();
    }

    // client decides the id
    @PutMapping("/room-quality-categories/{id}")
    public boolean insertRoomQualityCategory(
            @PathVariable String id, // could technically have DTO which doesn't include id to reduce network traffic
            @RequestBody Codebook roomQualityCategory) {
        return this.roomQualityCategoriesService.insertRoomQualityCategory(roomQualityCategory);
    }

    @DeleteMapping("/room-quality-categories/{id}")
    public boolean deleteRoomQualityCategory(@PathVariable String id) {
        return this.roomQualityCategoriesService.deleteRoomQualityCategory(id);
    }
}
