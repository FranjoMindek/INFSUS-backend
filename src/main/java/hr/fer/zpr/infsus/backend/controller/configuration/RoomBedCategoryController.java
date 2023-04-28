package hr.fer.zpr.infsus.backend.controller.configuration;

import hr.fer.zpr.infsus.backend.model.Codebook;
import hr.fer.zpr.infsus.backend.service.configuration.RoomBedCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomBedCategoryController {
    private final RoomBedCategoryService roomBedCategoryService;

    @GetMapping("/room-bed-categories")
    public List<Codebook> getRoomBedCategories() {
        return this.roomBedCategoryService.getRoomBedCategories();
    }

    // client decides the id
    @PutMapping("/room-bed-categories/{id}")
    public boolean insertRoomBedCategory(
            @PathVariable String id, // could technically have DTO which doesn't include id to reduce network traffic
            @RequestBody Codebook roomBedCategory) {
        return this.roomBedCategoryService.insertRoomBedCategory(roomBedCategory);
    }

    @DeleteMapping("/room-bed-categories/{id}")
    public boolean deleteRoomBedCategory(@PathVariable String id) {
        return this.roomBedCategoryService.deleteRoomBedCategory(id);
    }
}
