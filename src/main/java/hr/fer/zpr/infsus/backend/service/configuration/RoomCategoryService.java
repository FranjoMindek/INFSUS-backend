package hr.fer.zpr.infsus.backend.service.configuration;

import hr.fer.zpr.infsus.backend.model.RoomCategory;
import hr.fer.zpr.infsus.backend.repository.configuration.RoomCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomCategoryService {
    private final RoomCategoryRepository roomCategoryRepository;

    public List<RoomCategory> getRoomCategories() {
        return this.roomCategoryRepository.getRoomCategories();
    }

    public boolean insertRoomCategory(RoomCategory roomCategory) {
        return this.roomCategoryRepository.insertRoomCategory(roomCategory);
    }

    public boolean updateRoomCategory(RoomCategory roomCategory) {
        return this.roomCategoryRepository.updateRoomCategory(roomCategory);
    }

    public boolean insertUpdateCategory(RoomCategory roomCategory) {
        return this.roomCategoryRepository.insertUpdateRoomCategory(roomCategory);
    }

    public boolean deleteRoomCategory(String id) {
        return this.roomCategoryRepository.deleteRoomCategory(id);
    }
}
