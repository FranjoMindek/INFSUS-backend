package hr.fer.zpr.infsus.backend.features.configurations.roomcategories.data;

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
