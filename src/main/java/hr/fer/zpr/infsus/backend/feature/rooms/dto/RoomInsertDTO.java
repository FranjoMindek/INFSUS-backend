package hr.fer.zpr.infsus.backend.feature.rooms.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RoomInsertDTO {
    String roomCode;
    Integer roomFloor;
    String roomStatusId;
    String roomCategoryId;
}
