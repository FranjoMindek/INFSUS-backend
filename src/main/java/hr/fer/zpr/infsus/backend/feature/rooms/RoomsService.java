package hr.fer.zpr.infsus.backend.feature.rooms;

import hr.fer.zpr.infsus.backend.feature.rooms.dto.DetailedRoomDTO;
import hr.fer.zpr.infsus.backend.feature.rooms.dto.RoomDTO;
import hr.fer.zpr.infsus.backend.feature.rooms.dto.RoomInsertDTO;
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

    public List<DetailedRoomDTO> getDetailedRooms() {
        return this.roomsRepository.getDetailedRooms().stream()
                .map(RoomsMapper::toDTO)
                .toList();
    }

    public DetailedRoomDTO getDetailedRoomById(Long roomId) {
        return RoomsMapper.toDTO(this.roomsRepository.getDetailedRoomById(roomId));
    }

    public boolean updateRoomStatus(Long roomId, String roomStatusId) {
        return this.roomsRepository.updateRoomStatus(roomId, roomStatusId);
    }

    public boolean insertRoom(RoomInsertDTO roomInsertDTO) {
        return this.roomsRepository.insertRoom(RoomsMapper.toEntity(roomInsertDTO));
    }

    public boolean updateRoom(RoomDTO roomDTO) {
        return this.roomsRepository.updateRoom(RoomsMapper.toEntity(roomDTO));
    }

    public boolean deleteRoom(Long roomId) {
        return this.roomsRepository.deleteRoom(roomId);
    }
}
