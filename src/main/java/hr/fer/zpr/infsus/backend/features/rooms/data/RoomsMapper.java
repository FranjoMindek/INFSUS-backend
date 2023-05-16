package hr.fer.zpr.infsus.backend.features.rooms.data;

import hr.fer.zpr.infsus.backend.features.configurations.roomcategories.data.RoomCategoriesMapper;

public class RoomsMapper {

    public static RoomDTO toDTO(Room entity) {
        RoomDTO dto = new RoomDTO();
        dto.setRoomId(entity.getRoomId());
        dto.setRoomCode(entity.getRoomCode());
        dto.setRoomCategoryId(entity.getRoomCategoryId());
        dto.setRoomFloor(entity.getRoomFloor());
        dto.setRoomStatusId(entity.getRoomStatusId());
        return dto;
    }

    public static Room toEntity(RoomDTO dto) {
        Room entity = new Room();
        entity.setRoomId(dto.getRoomId());
        entity.setRoomCode(dto.getRoomCode());
        entity.setRoomCategoryId(dto.getRoomCategoryId());
        entity.setRoomFloor(dto.getRoomFloor());
        entity.setRoomStatusId(dto.getRoomStatusId());
        return entity;
    }

    public static RoomDetailed toEntity(RoomDetailedDTO dto) {
        RoomDetailed entity = new RoomDetailed();
        entity.setRoom(RoomsMapper.toEntity(dto.getRoom()));
        entity.setRoomCategory(RoomCategoriesMapper.toEntity(dto.getRoomCategory()));
        return entity;
    }

    public static RoomDetailedDTO toDTO(RoomDetailed entity) {
        RoomDetailedDTO dto = new RoomDetailedDTO();
        dto.setRoom(RoomsMapper.toDTO(entity.getRoom()));
        dto.setRoomCategory(RoomCategoriesMapper.toDTO(entity.getRoomCategory()));
        return dto;
    }

}
