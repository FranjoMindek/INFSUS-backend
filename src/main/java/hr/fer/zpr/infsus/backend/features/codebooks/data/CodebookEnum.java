package hr.fer.zpr.infsus.backend.features.codebooks.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public enum CodebookEnum {
    clientIds("client", "client_id", "client_first_name || ' ' || client_last_name", null),
    processes("process", "process_id", "process_name", null),
    overnightStayStatuses("status", "status_id", "status_name", "process_id = 'OVERNIGHT_STAY_STATUS'"),
    reservationStatuses("status", "status_id", "status_name", "process_id = 'RESERVATION_STATUS'"),
    rooms("room", "room_id", "room_floor || '/' || room_code", null),
    readyRooms("room", "room_id", "room_floor || '/' || room_code", "room_status_id = 'ROOM_STATUS.READY'"),
    roomStatuses("status", "status_id", "status_name", "process_id = 'ROOM_STATUS'"),
    roomQualityCategories("room_quality_category", "room_quality_category_id", "room_quality_category_name", null),
    roomBedCategories("room_bed_category", "room_bed_category_id", "room_bed_category_name", null);

    @NonNull
    @Getter
    private String table;
    @NonNull
    @Getter
    private String id;
    @NonNull
    @Getter
    private String name;
    @Getter
    private String where;
}
