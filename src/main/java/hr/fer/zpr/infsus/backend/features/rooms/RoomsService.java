package hr.fer.zpr.infsus.backend.features.rooms;

import hr.fer.zpr.infsus.backend.features.rooms.data.RoomDTO;
import hr.fer.zpr.infsus.backend.features.rooms.data.RoomDetailedDTO;
import hr.fer.zpr.infsus.backend.features.rooms.data.RoomsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomsService {

    private final RoomsRepository roomsRepository;

    public List<RoomDTO> getRooms() {
        return this.roomsRepository.getRooms().stream()
                .map(RoomsMapper::toDTO)
                .toList();
    }

    public List<RoomDetailedDTO> getRoomsDetailed() {
        return this.roomsRepository.getRoomsDetailed().stream()
                .map(RoomsMapper::toDTO)
                .toList();
    }

    public RoomDetailedDTO getRoomDetailedById(Long roomId) {
        return RoomsMapper.toDTO(this.roomsRepository.getRoomDetailedById(roomId));
    }

    public boolean updateRoomStatus(Long roomId, String roomStatusId) {
        return this.roomsRepository.updateRoomStatus(roomId, roomStatusId);
    }

    public boolean insertRoom(RoomDTO roomDTO) { return this.roomsRepository.insertRoom(RoomsMapper.toEntity(roomDTO)); }

    public boolean updateRoom(RoomDTO roomDTO) {
        return this.roomsRepository.updateRoom(RoomsMapper.toEntity(roomDTO));
    }

    public boolean deleteRoom(Long roomId) {
        return this.roomsRepository.deleteRoom(roomId);
    }
}
