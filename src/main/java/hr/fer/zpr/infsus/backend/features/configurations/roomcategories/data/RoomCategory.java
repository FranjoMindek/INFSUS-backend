package hr.fer.zpr.infsus.backend.features.configurations.roomcategories.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoomCategory {
    String roomCategoryId;
    String roomCategoryName;
    Long roomCategoryPrice;
    String roomBedCategoryId;
    String roomQualityCategoryId;
}
