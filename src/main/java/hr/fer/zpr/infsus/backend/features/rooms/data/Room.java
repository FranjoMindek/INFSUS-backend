package hr.fer.zpr.infsus.backend.features.rooms.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Room {
    Long roomId;
    String roomCode;
    Integer roomFloor;
    String roomStatusId;
    String roomCategoryId;
}
