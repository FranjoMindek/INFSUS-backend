package hr.fer.zpr.infsus.backend.feature.configurations.roomqualitycategories;

import hr.fer.zpr.infsus.backend.feature.codebooks.CodebooksService;
import hr.fer.zpr.infsus.backend.feature.codebooks.data.Codebook;
import hr.fer.zpr.infsus.backend.feature.codebooks.data.CodebookEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomQualityCategoriesService {

    private final RoomQualityCategoriesRepository roomQualityCategoriesRepository;
    private final CodebooksService codebooksService;

    public List<Codebook> getRoomQualityCategories() {
        return this.codebooksService.getCodebookByEnum(CodebookEnum.roomQualityCategories);
    }

    public boolean insertRoomQualityCategory(Codebook roomBedCategory) {
        return this.roomQualityCategoriesRepository.insertRoomQualityCategory(roomBedCategory);
    }

    public boolean deleteRoomQualityCategory(String id) {
        return this.roomQualityCategoriesRepository.deleteRoomQualityCategory(id);
    }
}
