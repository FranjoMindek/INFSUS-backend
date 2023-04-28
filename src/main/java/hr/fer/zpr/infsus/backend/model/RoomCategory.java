package hr.fer.zpr.infsus.backend.model;

import lombok.*;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Repository
@ToString
public class RoomCategory {
    String roomCategoryId;
    String roomCategoryName;
    Long roomCategoryPrice;
    String roomBedCategoryId;
    String roomQualityCategoryId;
}
