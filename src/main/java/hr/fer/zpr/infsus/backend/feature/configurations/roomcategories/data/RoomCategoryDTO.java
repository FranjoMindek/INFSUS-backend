package hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RoomCategoryDTO {
    String roomCategoryId;
    String roomCategoryName;
    Long roomCategoryPrice;
    String roomBedCategoryId;
    String roomQualityCategoryId;
}
