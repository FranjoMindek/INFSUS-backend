package hr.fer.zpr.infsus.backend.controller;

import hr.fer.zpr.infsus.backend.model.Room;
import hr.fer.zpr.infsus.backend.model.RoomDetailed;
import hr.fer.zpr.infsus.backend.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/rooms")
    public List<RoomDetailed> getRooms() {
        return this.roomService.getRoomsDetailed();
    }

    @GetMapping("/rooms/{roomId}")
    public RoomDetailed getRoomById(@PathVariable Long roomId) {
        return this.roomService.getRoomDetailedById(roomId);
    }

    @PostMapping("/rooms")
    public boolean insertRoom(@RequestBody Room room) {
        return this.roomService.insertRoom(room);
    }

    @PutMapping("/rooms/{roomId}")
    public boolean updateRoom(@PathVariable Long roomId,
                              @RequestBody Room room) {
        return this.roomService.updateRoom(room);
    }

    @DeleteMapping("/rooms/{roomId}")
    public boolean deleteRoom(@PathVariable Long roomId) {
        return this.roomService.deleteRoom(roomId);
    }
}
