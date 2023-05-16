package hr.fer.zpr.infsus.backend.features.rooms.data;

import hr.fer.zpr.infsus.backend.features.configurations.roomcategories.data.RoomCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDetailed {
    Room room;
    RoomCategory roomCategory;
}
