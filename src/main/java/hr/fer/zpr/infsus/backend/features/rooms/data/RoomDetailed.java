package hr.fer.zpr.infsus.backend.features.rooms.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoomDetailed {
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
