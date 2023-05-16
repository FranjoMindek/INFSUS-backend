package hr.fer.zpr.infsus.backend.feature.rooms.dto;

import hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.data.RoomCategoryDTO;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class DetailedRoomDTO {
    RoomDTO room;
    RoomCategoryDTO roomCategory;
}

