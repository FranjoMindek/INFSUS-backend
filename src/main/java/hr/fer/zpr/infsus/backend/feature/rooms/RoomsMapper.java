package hr.fer.zpr.infsus.backend.feature.rooms;

import hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.RoomCategoriesMapper;
import hr.fer.zpr.infsus.backend.feature.rooms.dto.DetailedRoomDTO;
import hr.fer.zpr.infsus.backend.feature.rooms.dto.RoomDTO;
import hr.fer.zpr.infsus.backend.feature.rooms.dto.RoomInsertDTO;
import hr.fer.zpr.infsus.backend.feature.rooms.model.DetailedRoom;
import hr.fer.zpr.infsus.backend.feature.rooms.model.Room;

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

    public static Room toEntity(RoomInsertDTO dto) {
        return Room.builder()
                .roomCode(dto.getRoomCode())
                .roomFloor(dto.getRoomFloor())
                .roomStatusId(dto.getRoomStatusId())
                .roomCategoryId(dto.getRoomCategoryId())
                .build();
    }

    public static DetailedRoom toEntity(DetailedRoomDTO dto) {
        DetailedRoom entity = new DetailedRoom();
        entity.setRoom(RoomsMapper.toEntity(dto.getRoom()));
        entity.setRoomCategory(RoomCategoriesMapper.toEntity(dto.getRoomCategory()));
        return entity;
    }

    public static DetailedRoomDTO toDTO(DetailedRoom entity) {
        DetailedRoomDTO dto = new DetailedRoomDTO();
        dto.setRoom(RoomsMapper.toDTO(entity.getRoom()));
        dto.setRoomCategory(RoomCategoriesMapper.toDTO(entity.getRoomCategory()));
        return dto;
    }

}
