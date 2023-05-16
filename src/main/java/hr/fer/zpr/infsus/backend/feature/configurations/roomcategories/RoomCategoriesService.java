package hr.fer.zpr.infsus.backend.feature.configurations.roomcategories;

import hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.data.RoomCategoriesMapper;
import hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.data.RoomCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomCategoriesService {
    private final RoomCategoriesRepository roomCategoriesRepository;

    public List<RoomCategoryDTO> getRoomCategories() {
        return this.roomCategoriesRepository.getRoomCategories().stream()
                .map(RoomCategoriesMapper::toDTO)
                .toList();
    }

    public boolean insertRoomCategory(RoomCategoryDTO roomCategoryDTO) {
        return this.roomCategoriesRepository.insertRoomCategory(RoomCategoriesMapper.toEntity(roomCategoryDTO));
    }

    public boolean updateRoomCategory(RoomCategoryDTO roomCategoryDTO) {
        return this.roomCategoriesRepository.updateRoomCategory(RoomCategoriesMapper.toEntity(roomCategoryDTO));
    }

    public boolean insertUpdateCategory(RoomCategoryDTO roomCategoryDTO) {
        return this.roomCategoriesRepository.insertUpdateRoomCategory(RoomCategoriesMapper.toEntity(roomCategoryDTO));
    }

    public boolean deleteRoomCategory(String id) {
        return this.roomCategoriesRepository.deleteRoomCategory(id);
    }
}
