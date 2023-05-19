package hr.fer.zpr.infsus.backend.feature.rooms;

import hr.fer.zpr.infsus.backend.feature.rooms.dto.DetailedRoomDTO;
import hr.fer.zpr.infsus.backend.feature.rooms.dto.RoomDTO;
import hr.fer.zpr.infsus.backend.feature.rooms.dto.RoomInsertDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RoomsController {

    private final RoomsService roomsService;

    @GetMapping("/detailed-rooms")
    public ResponseEntity<List<DetailedRoomDTO>> getDetailedRooms() {
        return ResponseEntity.ok().body(this.roomsService.getDetailedRooms());
    }

    @GetMapping("/detailed-rooms/{id}")
    public ResponseEntity<DetailedRoomDTO> getDetailedRoomById(@PathVariable Long id) {
        DetailedRoomDTO dto = this.roomsService.getDetailedRoomById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/rooms")
    public ResponseEntity<?> insertRoom(@RequestBody RoomInsertDTO room) {
        Long id = this.roomsService.insertRoom(room);
        return ResponseEntity.created(URI.create("api/rooms/" + id)).build();
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable Long id,
                                             @RequestBody RoomDTO room) {
        if (this.roomsService.updateRoom(room)) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long id) {
        if (this.roomsService.deleteRoom(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
