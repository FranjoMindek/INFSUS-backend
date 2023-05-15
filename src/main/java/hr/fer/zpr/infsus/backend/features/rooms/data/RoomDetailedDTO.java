package hr.fer.zpr.infsus.backend.features.rooms.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RoomDetailedDTO {
    Long roomId;
    String roomCode;
    Integer roomFloor;
    String roomStatusId;
    String roomCategoryId;
    String statusName;
    String roomCategoryPrice;
    String roomBedCategoryId;
    String roomQualityCategoryId;
    String roomBedCategoryName;
    String roomQualityCategoryName;
}
