package hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomCategory {
    String roomCategoryId;
    String roomCategoryName;
    Long roomCategoryPrice;
    String roomBedCategoryId;
    String roomQualityCategoryId;
}
