package hr.fer.zpr.infsus.backend.service;

import hr.fer.zpr.infsus.backend.model.Codebook;
import hr.fer.zpr.infsus.backend.repository.CodebookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@RequiredArgsConstructor
public class CodebookService {

    private final CodebookRepository codebooksRepository;

    public Map<String, List<Codebook>> getCodebooks() {
        Map<String, List<Codebook>> map = new TreeMap<>();
        map.put("clientIds", this.codebooksRepository.getCodebookTemplate(
                "client", "client_id", "client_first_name || ' ' || client_last_name"
        ));
//        map.put("roomCategories", this.codebooksRepository.getCodebookTemplate(
//                "roomCategories", "roomCategories", "roomCategories"
//        ));
        map.put("roomBedCategories", this.codebooksRepository.getCodebookTemplate(
                "room_bed_category", "room_bed_category_id", "room_bed_category_name"
        ));
        map.put("roomQualityCategories", this.codebooksRepository.getCodebookTemplate(
                "room_quality_category", "room_quality_category_id", "room_quality_category_name"
        ));
        map.put("processes", this.codebooksRepository.getCodebookTemplate(
                "process", "process_id", "process_name"
        ));
        map.put("roomStatuses", this.codebooksRepository.getCodebookTemplate(
                "status", "status_id", "status_name", "process_id = 'ROOM_STATUS'"
        ));
        map.put("reservationStatuses", this.codebooksRepository.getCodebookTemplate(
                "status", "status_id", "status_name", "process_id = 'RESERVATION_STATUS'"
        ));
        map.put("overnightStayStatuses", this.codebooksRepository.getCodebookTemplate(
                "status", "status_id", "status_name", "process_id = 'OVERNIGHT_STAY_STATUS'"
        ));

        return map;
    }

}
