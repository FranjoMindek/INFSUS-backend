package hr.fer.zpr.infsus.backend.feature.overnightstays;

import hr.fer.zpr.infsus.backend.feature.clients.ClientsService;
import hr.fer.zpr.infsus.backend.feature.overnightstays.dto.OvernightStayDTO;
import hr.fer.zpr.infsus.backend.feature.overnightstays.dto.OvernightStayInsertDTO;
import hr.fer.zpr.infsus.backend.feature.rooms.RoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OvernightStaysService {

    private final OvernightStaysRepository overnightStaysRepository;
    private final ClientsService clientsService;
    private final RoomsService roomsService;

    public List<OvernightStayDTO> getOvernightStays() {
        return this.overnightStaysRepository.getOvernightStays().stream()
                .map(OvernightStaysMapper::toDTO)
                .toList();
    }

    public OvernightStayDTO getOvernightStayById(Long overnightStayId) {
        return OvernightStaysMapper.toDTO(this.overnightStaysRepository.getOvernightStayById(overnightStayId));
    }

    public boolean insertOvernightStay(OvernightStayInsertDTO overnightStayInsertDTO) {
        Long clientId = this.clientsService.insertClientIfNew(overnightStayInsertDTO.getClientInsertDTO());
        this.roomsService.updateRoomStatus(overnightStayInsertDTO.getRoomId(),  "ROOM_STATUS.OCCUPIED");

        return this.overnightStaysRepository.insertOvernightStay(
                OvernightStaysMapper.toEntity(overnightStayInsertDTO, clientId));
    }

    public boolean updateOvernightStay(OvernightStayDTO overnightStayDTO) {
        return this.overnightStaysRepository.updateOvernightStay(OvernightStaysMapper.toEntity(overnightStayDTO));
    }

    public boolean deleteOvernightStay(Long overnightStayId) {
        return this.overnightStaysRepository.deleteOvernightStay(overnightStayId);
    }
}
