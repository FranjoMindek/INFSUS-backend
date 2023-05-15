package hr.fer.zpr.infsus.backend.features.rooms;

import hr.fer.zpr.infsus.backend.features.rooms.data.RoomDTO;
import hr.fer.zpr.infsus.backend.features.rooms.data.RoomDetailedDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomsController {

    private final RoomsService roomsService;

    @GetMapping("/rooms")
    public List<RoomDetailedDTO> getRooms() {
        return this.roomsService.getRoomsDetailed();
    }

    @GetMapping("/rooms/{roomId}")
    public RoomDetailedDTO getRoomById(@PathVariable Long roomId) {
        return this.roomsService.getRoomDetailedById(roomId);
    }

    @PostMapping("/rooms")
    public boolean insertRoom(@RequestBody RoomDTO room) {
        return this.roomsService.insertRoom(room);
    }

    @PutMapping("/rooms/{roomId}")
    public boolean updateRoom(@PathVariable Long roomId,
                              @RequestBody RoomDTO room) {
        return this.roomsService.updateRoom(room);
    }

    @DeleteMapping("/rooms/{roomId}")
    public boolean deleteRoom(@PathVariable Long roomId) {
        return this.roomsService.deleteRoom(roomId);
    }
}
