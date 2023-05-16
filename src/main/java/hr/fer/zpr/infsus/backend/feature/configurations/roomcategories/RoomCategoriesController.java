package hr.fer.zpr.infsus.backend.feature.configurations.roomcategories;

import hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.data.RoomCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomCategoriesController {
    private final RoomCategoriesService roomCategoriesService;

    @GetMapping("/room-categories")
    public List<RoomCategoryDTO> getRoomCategories() {
        return this.roomCategoriesService.getRoomCategories();
    }

    // client decides the id -> update or insert??? merge?
    @PutMapping("/room-categories/{id}")
    public boolean insertRoomCategory(
            @PathVariable String id, // could technically have DTO which doesn't include id to reduce network traffic
            @RequestBody RoomCategoryDTO roomCategory) {
        return this.roomCategoriesService.insertUpdateCategory(roomCategory);
    }

    @DeleteMapping("/room-categories/{id}")
    public boolean deleteRoomCategory(@PathVariable String id) {
        return this.roomCategoriesService.deleteRoomCategory(id);
    }
}