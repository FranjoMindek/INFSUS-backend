package hr.fer.zpr.infsus.backend.features.rooms.data;

import hr.fer.zpr.infsus.backend.features.configurations.roomcategories.data.RoomCategoryDTO;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class RoomDetailedDTO {
    RoomDTO room;
    RoomCategoryDTO roomCategory;
}

