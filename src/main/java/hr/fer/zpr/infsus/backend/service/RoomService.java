package hr.fer.zpr.infsus.backend.service;

import hr.fer.zpr.infsus.backend.model.Room;
import hr.fer.zpr.infsus.backend.model.RoomDetailed;
import hr.fer.zpr.infsus.backend.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room> getRooms() {
        return this.roomRepository.getRooms();
    }

    public List<RoomDetailed> getRoomsDetailed() {
        return this.roomRepository.getRoomsDetailed();
    }

    public RoomDetailed getRoomDetailedById(Long roomId) {
        return this.roomRepository.getRoomDetailedById(roomId);
    }

    public boolean updateRoomStatus(Long roomId, String roomStatusId) {
        return this.roomRepository.updateRoomStatus(roomId, roomStatusId);
    }

    public boolean insertRoom(Room room) { return this.roomRepository.insertRoom(room); }

    public boolean updateRoom(Room room) {
        return this.roomRepository.updateRoom(room);
    }

    public boolean deleteRoom(Long roomId) {
        return this.roomRepository.deleteRoom(roomId);
    }
}
