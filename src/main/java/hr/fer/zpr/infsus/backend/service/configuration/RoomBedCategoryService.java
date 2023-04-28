package hr.fer.zpr.infsus.backend.service.configuration;

import hr.fer.zpr.infsus.backend.model.Codebook;
import hr.fer.zpr.infsus.backend.repository.configuration.RoomBedCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomBedCategoryService {
    private final RoomBedCategoryRepository roomBedCategoryRepository;

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
