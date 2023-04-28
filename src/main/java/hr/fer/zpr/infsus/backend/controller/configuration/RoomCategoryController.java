package hr.fer.zpr.infsus.backend.controller.configuration;

import hr.fer.zpr.infsus.backend.model.RoomCategory;
import hr.fer.zpr.infsus.backend.service.configuration.RoomCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomCategoryController {
    private final RoomCategoryService roomCategoryService;

    @GetMapping("/room-categories")
    public List<RoomCategory> getRoomCategories() {
        return this.roomCategoryService.getRoomCategories();
    }

    // client decides the id -> update or insert??? merge?
    @PutMapping("/room-categories/{id}")
    public boolean insertRoomCategory(
            @PathVariable String id, // could technically have DTO which doesn't include id to reduce network traffic
            @RequestBody RoomCategory roomCategory) {
        return this.roomCategoryService.insertUpdateCategory(roomCategory);
    }

    @DeleteMapping("/room-categories/{id}")
    public boolean deleteRoomCategory(@PathVariable String id) {
        return this.roomCategoryService.deleteRoomCategory(id);
    }
}
