package hr.fer.zpr.infsus.backend.controller.configuration;

import hr.fer.zpr.infsus.backend.model.Codebook;
import hr.fer.zpr.infsus.backend.service.configuration.RoomQualityCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomQualityCategoryController {

    private final RoomQualityCategoryService roomQualityCategoryService;

    @GetMapping("/room-quality-categories")
    public List<Codebook> getRoomQualityCategories() {
        return this.roomQualityCategoryService.getRoomQualityCategories();
    }

    // client decides the id
    @PutMapping("/room-quality-categories/{id}")
    public boolean insertRoomQualityCategory(
            @PathVariable String id, // could technically have DTO which doesn't include id to reduce network traffic
            @RequestBody Codebook roomQualityCategory) {
        return this.roomQualityCategoryService.insertRoomQualityCategory(roomQualityCategory);
    }

    @DeleteMapping("/room-quality-categories/{id}")
    public boolean deleteRoomQualityCategory(@PathVariable String id) {
        return this.roomQualityCategoryService.deleteRoomQualityCategory(id);
    }
}
