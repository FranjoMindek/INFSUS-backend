package hr.fer.zpr.infsus.backend.feature.configurations.roomcategories;

import hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.dto.RoomCategoryDTO;
import hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.model.RoomCategory;

public class RoomCategoriesMapper {

    public static RoomCategory toEntity(RoomCategoryDTO dto) {
        RoomCategory entity = new RoomCategory();
        entity.setRoomCategoryId(dto.getRoomCategoryId());
        entity.setRoomCategoryName(dto.getRoomCategoryName());
        entity.setRoomCategoryPrice(dto.getRoomCategoryPrice());
        entity.setRoomBedCategoryId(dto.getRoomBedCategoryId());
        entity.setRoomQualityCategoryId(dto.getRoomQualityCategoryId());
        return entity;
    }

   public static RoomCategoryDTO toDTO(RoomCategory entity) {
       RoomCategoryDTO dto = new RoomCategoryDTO();
       dto.setRoomCategoryId(entity.getRoomCategoryId());
       dto.setRoomCategoryName(entity.getRoomCategoryName());
       dto.setRoomCategoryPrice(entity.getRoomCategoryPrice());
       dto.setRoomBedCategoryId(entity.getRoomBedCategoryId());
       dto.setRoomQualityCategoryId(entity.getRoomQualityCategoryId());
       return dto;

   }
}
