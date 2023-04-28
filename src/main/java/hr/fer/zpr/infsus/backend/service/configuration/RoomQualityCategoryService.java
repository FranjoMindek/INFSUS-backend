package hr.fer.zpr.infsus.backend.service.configuration;

import hr.fer.zpr.infsus.backend.model.Codebook;
import hr.fer.zpr.infsus.backend.repository.configuration.RoomQualityCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomQualityCategoryService {
    private final RoomQualityCategoryRepository roomQualityCategoryRepository;

    public List<Codebook> getRoomQualityCategories() {
        return this.roomQualityCategoryRepository.getRoomQualityCategories();
    }

    public boolean insertRoomQualityCategory(Codebook roomBedCategory) {
        return this.roomQualityCategoryRepository.insertRoomQualityCategory(roomBedCategory);
    }

    public boolean deleteRoomQualityCategory(String id) {
        return this.roomQualityCategoryRepository.deleteRoomQualityCategory(id);
    }
}
