package hr.fer.zpr.infsus.backend.features.rooms;

import hr.fer.zpr.infsus.backend.features.rooms.data.Room;
import hr.fer.zpr.infsus.backend.features.rooms.data.RoomDetailed;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomsRepository {

    private final NamedParameterJdbcTemplate njdbc;

    public RoomsRepository(@Qualifier("NamedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    public List<Room> getRooms() {
        String query = """
                SELECT
                    *
                FROM
                    room
                """;

        return njdbc.query(query, BeanPropertyRowMapper.newInstance(Room.class));
    }

    public List<RoomDetailed> getRoomsDetailed() {
        String query = """
                SELECT 
                    r.*,
                    s.status_name,
                    rc.room_category_price,
                    rc.room_bed_category_id,
                    rc.room_quality_category_id,
                    rbc.room_bed_category_name,
                    rqc.room_quality_category_name
                FROM 
                    room r
                    JOIN status s
                        ON s.status_id = r.room_status_id
                    JOIN room_category rc
                        ON rc.room_category_id = r.room_category_id
                    JOIN room_bed_category rbc
                        ON rbc.room_bed_category_id = rc.room_bed_category_id
                    JOIN room_quality_category rqc
                        ON rqc.room_quality_category_id = rc.room_quality_category_id
                """;

        return njdbc.query(query, BeanPropertyRowMapper.newInstance(RoomDetailed.class));
    }

    public RoomDetailed getRoomDetailedById(Long roomId) {
        String query = """
                SELECT 
                    r.*,
                    s.status_name,
                    rc.room_category_price,
                    rc.room_bed_category_id,
                    rc.room_quality_category_id,
                    rbc.room_bed_category_name,
                    rqc.room_quality_category_name
                FROM 
                    room r
                    JOIN status s
                        ON s.status_id = r.room_status_id
                    JOIN room_category rc
                        ON rc.room_category_id = r.room_category_id
                    JOIN room_bed_category rbc
                        ON rbc.room_bed_category_id = rc.room_bed_category_id
                    JOIN room_quality_category rqc
                        ON rqc.room_quality_category_id = rc.room_quality_category_id
                WHERE
                    r.room_id = :roomId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource("roomId", roomId);

        return njdbc.queryForObject(query, parameters, BeanPropertyRowMapper.newInstance(RoomDetailed.class));
    }

    public boolean insertRoom(Room room) {
        String query = """
                INSERT INTO 
                    room (room_code, room_floor, room_status_id, room_category_id)
                VALUES 
                    (:roomCode, :roomFloor, :roomStatusId, :roomCategoryId)
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("roomCode", room.getRoomCode());
        parameters.addValue("roomFloor", room.getRoomFloor());
        parameters.addValue("roomStatusId", room.getRoomStatusId());
        parameters.addValue("roomCategoryId", room.getRoomCategoryId());

        return njdbc.update(query, parameters) > 0;
    }
    public boolean updateRoom(Room room) {
        String query = """
                UPDATE 
                    room
                SET
                    roomCode = :roomCode,
                    roomFloor = :roomFloor,
                    roomStatusId = :roomStatusId,
                    roomCategoryId = :roomCategoryId
                WHERE
                    room_id = :roomId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("roomId", room.getRoomId());
        parameters.addValue("roomCode", room.getRoomCode());
        parameters.addValue("roomFloor", room.getRoomFloor());
        parameters.addValue("roomStatusId", room.getRoomStatusId());
        parameters.addValue("roomCategoryId", room.getRoomCategoryId());

        return njdbc.update(query, parameters) > 0;
    }

    public boolean updateRoomStatus(Long roomId, String roomStatusId) {
        String query = """
                UPDATE
                    room
                SET
                    room_status_id = :roomStatusId
                WHERE
                    room_id = :roomId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("roomId", roomId);
        parameters.addValue("roomStatusId", roomStatusId);

        return this.njdbc.update(query, parameters) > 0;
    }

    public boolean deleteRoom(Long roomId) {
        String query = """
                DELETE
                FROM
                    room
                WHERE
                    room_id = :roomId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource("roomId", roomId);

        return this.njdbc.update(query, parameters) > 0;
    }
}
