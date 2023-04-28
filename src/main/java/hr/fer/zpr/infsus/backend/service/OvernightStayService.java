package hr.fer.zpr.infsus.backend.service;

import hr.fer.zpr.infsus.backend.model.OvernightStay;
import hr.fer.zpr.infsus.backend.model.OvernightStayInsert;
import hr.fer.zpr.infsus.backend.repository.OvernightStayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OvernightStayService {

    private final OvernightStayRepository overnightStayRepository;
    private final ClientService clientService;
    private final RoomService roomService;

    public List<OvernightStay> getOvernightStays() {
        return this.overnightStayRepository.getOvernightStays();
    }

    public OvernightStay getOvernightStayById(Long overnightStayId) {
        return this.overnightStayRepository.getOvernightStayById(overnightStayId);
    }

    public boolean insertOvernightStay(OvernightStayInsert overnightStayInsert) {
        Long clientId = this.clientService.insertClientIfNew(overnightStayInsert);
        this.roomService.updateRoomStatus(overnightStayInsert.getRoomId(), "ROOM_STATUS.OCCUPIED");
        return this.overnightStayRepository.insertOvernightStay(overnightStayInsert, clientId);
    }

    public boolean updateOvernightStay(OvernightStay overnightStay) {
        return this.overnightStayRepository.updateOvernightStay(overnightStay);
    }

    public boolean deleteOvernightStay(Long overnightStayId) {
        return this.overnightStayRepository.deleteOvernightStay(overnightStayId);
    }
}
