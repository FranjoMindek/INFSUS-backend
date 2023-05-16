package hr.fer.zpr.infsus.backend.features.rooms.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    Long roomId;
    String roomCode;
    Integer roomFloor;
    String roomStatusId;
    String roomCategoryId;
}
