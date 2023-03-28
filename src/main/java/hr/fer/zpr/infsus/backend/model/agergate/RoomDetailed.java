package hr.fer.zpr.infsus.backend.model.agergate;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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
