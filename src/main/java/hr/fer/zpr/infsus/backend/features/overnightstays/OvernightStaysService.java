package hr.fer.zpr.infsus.backend.features.overnightstays;

import hr.fer.zpr.infsus.backend.features.clients.ClientsService;
import hr.fer.zpr.infsus.backend.features.clients.data.Client;
import hr.fer.zpr.infsus.backend.features.overnightstays.data.OvernightStay;
import hr.fer.zpr.infsus.backend.features.overnightstays.data.OvernightStayDTO;
import hr.fer.zpr.infsus.backend.features.overnightstays.data.OvernightStayInsertDTO;
import hr.fer.zpr.infsus.backend.features.rooms.RoomsService;
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
        Long clientId = this.clientsService.insertClientIfNew(
                Client.builder()
                        .clientNationalId(overnightStayInsertDTO.getClientNationalId())
                        .clientPhoneNumber(overnightStayInsertDTO.getClientPhoneNumber())
                        .clientFirstName(overnightStayInsertDTO.getClientFirstName())
                        .clientLastName(overnightStayInsertDTO.getClientLastName())
                        .build());
        this.roomsService.updateRoomStatus(overnightStayInsertDTO.getRoomId(), "ROOM_STATUS.OCCUPIED");

        return this.overnightStaysRepository.insertOvernightStay(
                OvernightStay.builder()
                        .clientId(clientId)
                        .roomId(overnightStayInsertDTO.getRoomId())
                        .overnightStayDateFrom(overnightStayInsertDTO.getOvernightStayDateFrom())
                        .overnightStayDateTo(overnightStayInsertDTO.getOvernightStayDateTo())
                        .build()
        );
    }

    public boolean updateOvernightStay(OvernightStayDTO overnightStayDTO) {
        return this.overnightStaysRepository.updateOvernightStay(OvernightStaysMapper.toEntity(overnightStayDTO));
    }

    public boolean deleteOvernightStay(Long overnightStayId) {
        return this.overnightStaysRepository.deleteOvernightStay(overnightStayId);
    }
}
