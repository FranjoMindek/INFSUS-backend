package hr.fer.zpr.infsus.backend.features.configurations.roomcategories;

import hr.fer.zpr.infsus.backend.features.configurations.roomcategories.data.RoomCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomCategoriesService {
    private final RoomCategoriesRepository roomCategoriesRepository;

    public List<RoomCategory> getRoomCategories() {
        return this.roomCategoriesRepository.getRoomCategories();
    }

    public boolean insertRoomCategory(RoomCategory roomCategory) {
        return this.roomCategoriesRepository.insertRoomCategory(roomCategory);
    }

    public boolean updateRoomCategory(RoomCategory roomCategory) {
        return this.roomCategoriesRepository.updateRoomCategory(roomCategory);
    }

    public boolean insertUpdateCategory(RoomCategory roomCategory) {
        return this.roomCategoriesRepository.insertUpdateRoomCategory(roomCategory);
    }

    public boolean deleteRoomCategory(String id) {
        return this.roomCategoriesRepository.deleteRoomCategory(id);
    }
}
