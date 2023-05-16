package hr.fer.zpr.infsus.backend.feature.rooms;

import hr.fer.zpr.infsus.backend.feature.rooms.dto.DetailedRoomDTO;
import hr.fer.zpr.infsus.backend.feature.rooms.dto.RoomDTO;
import hr.fer.zpr.infsus.backend.feature.rooms.dto.RoomInsertDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomsController {

    private final RoomsService roomsService;

    @GetMapping("/detailed-rooms")
    public List<DetailedRoomDTO> getDetailedRooms() {
        return this.roomsService.getDetailedRooms();
    }

    @GetMapping("/detailed-rooms/{id}")
    public DetailedRoomDTO getDetailedRoomById(@PathVariable Long id) {
        return this.roomsService.getDetailedRoomById(id);
    }

    @PostMapping("/rooms")
    public boolean insertRoom(@RequestBody RoomInsertDTO room) {
        return this.roomsService.insertRoom(room);
    }

    @PutMapping("/rooms/{id}")
    public boolean updateRoom(@PathVariable Long id,
                              @RequestBody RoomDTO room) {
        return this.roomsService.updateRoom(room);
    }

    @DeleteMapping("/rooms/{id}")
    public boolean deleteRoom(@PathVariable Long id) {
        return this.roomsService.deleteRoom(id);
    }
}
