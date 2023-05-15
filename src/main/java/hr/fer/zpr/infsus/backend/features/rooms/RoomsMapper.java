package hr.fer.zpr.infsus.backend.features.rooms;

import hr.fer.zpr.infsus.backend.features.rooms.data.Room;
import hr.fer.zpr.infsus.backend.features.rooms.data.RoomDTO;
import hr.fer.zpr.infsus.backend.features.rooms.data.RoomDetailed;
import hr.fer.zpr.infsus.backend.features.rooms.data.RoomDetailedDTO;

public class RoomsMapper {

    public static Room toEntity(RoomDTO dto) {
        return Room.builder()
                .roomId(dto.getRoomId())
                .roomCode(dto.getRoomCode())
                .roomCategoryId(dto.getRoomCategoryId())
                .roomFloor(dto.getRoomFloor())
                .roomStatusId(dto.getRoomStatusId())
                .build();
    }

    public static RoomDTO toDTO(Room entity) {
        RoomDTO dto = new RoomDTO();
        dto.setRoomId(entity.getRoomId());
        dto.setRoomCode(entity.getRoomCode());
        dto.setRoomCategoryId(entity.getRoomCategoryId());
        dto.setRoomFloor(entity.getRoomFloor());
        dto.setRoomStatusId(entity.getRoomStatusId());
        return dto;
    }

    public static RoomDetailed toEntity(RoomDetailedDTO dto) {
        return RoomDetailed.builder()
                .roomId(dto.getRoomId())
                .roomCode(dto.getRoomCode())
                .roomFloor(dto.getRoomFloor())
                .roomStatusId(dto.getRoomStatusId())
                .roomCategoryId(dto.getRoomCategoryId())
                .statusName(dto.getStatusName())
                .roomCategoryPrice(dto.getRoomCategoryPrice())
                .roomBedCategoryId(dto.getRoomCategoryId())
                .roomQualityCategoryId(dto.getRoomQualityCategoryId())
                .roomBedCategoryName(dto.getRoomBedCategoryName())
                .roomQualityCategoryName(dto.getRoomQualityCategoryName())
                .build();
    }

    public static RoomDetailedDTO toDTO(RoomDetailed entity) {
        RoomDetailedDTO dto = new RoomDetailedDTO();
        dto.setRoomId(entity.getRoomId());
        dto.setRoomCode(entity.getRoomCode());
        dto.setRoomFloor(entity.getRoomFloor());
        dto.setRoomStatusId(entity.getRoomStatusId());
        dto.setRoomCategoryId(entity.getRoomCategoryId());
        dto.setStatusName(entity.getStatusName());
        dto.setRoomCategoryPrice(entity.getRoomCategoryPrice());
        dto.setRoomBedCategoryId(entity.getRoomBedCategoryId());
        dto.setRoomQualityCategoryId(entity.getRoomQualityCategoryId());
        dto.setRoomBedCategoryName(entity.getRoomBedCategoryName());
        dto.setRoomQualityCategoryName(entity.getRoomQualityCategoryName());
        return dto;
    }

}
