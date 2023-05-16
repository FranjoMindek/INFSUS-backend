package hr.fer.zpr.infsus.backend.feature.rooms.model;

import hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.data.RoomCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailedRoom {
    Room room;
    RoomCategory roomCategory;
}
