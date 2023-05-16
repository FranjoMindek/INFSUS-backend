package hr.fer.zpr.infsus.backend.feature.configurations.roombedcategories;

import hr.fer.zpr.infsus.backend.feature.codebooks.data.Codebook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomBedCategoriesService {
    private final RoomBedCategoriesRepository roomBedCategoryRepository;

    public List<Codebook> getRoomBedCategories() {
        return this.roomBedCategoryRepository.getRoomBedCategories();
    }

    public boolean insertRoomBedCategory(Codebook roomBedCategory) {
        return this.roomBedCategoryRepository.insertRoomBedCategory(roomBedCategory);
    }

    public boolean deleteRoomBedCategory(String id) {
        return this.roomBedCategoryRepository.deleteRoomBedCategory(id);
    }
}
