package hr.fer.zpr.infsus.backend.feature.rooms;

import hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.model.RoomCategory;
import hr.fer.zpr.infsus.backend.feature.rooms.model.DetailedRoom;
import hr.fer.zpr.infsus.backend.feature.rooms.model.Room;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public List<DetailedRoom> getDetailedRooms() {
        String query = """
                SELECT 
                    r.room_id,
                    r.room_code,
                    r.room_category_id,
                    r.room_floor,
                    r.room_status_id,
                    rc.room_category_id,
                    rc.room_category_name,
                    rc.room_category_price,
                    rc.room_bed_category_id,
                    rc.room_quality_category_id
                FROM 
                    room r
                    JOIN room_category rc
                        ON rc.room_category_id = r.room_category_id
                """;

        List<DetailedRoom> lista = njdbc.query(query, new RoomDetailedRowMapper());
        return lista;
    }

    public DetailedRoom getDetailedRoomById(Long roomId) {
        String query = """
                SELECT 
                    r.room_id,
                    r.room_code,
                    r.room_category_id,
                    r.room_floor,
                    r.room_status_id,
                    rc.room_category_id,
                    rc.room_category_name,
                    rc.room_category_price,
                    rc.room_bed_category_id,
                    rc.room_quality_category_id
                FROM 
                    room r
                    JOIN room_category rc
                        ON rc.room_category_id = r.room_category_id
                WHERE
                    r.room_id = :roomId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource("roomId", roomId);

        return njdbc.queryForObject(query, parameters, new RoomDetailedRowMapper());
    }

    public Long insertRoom(Room room) {
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
        KeyHolder keyHolder = new GeneratedKeyHolder();

        njdbc.update(query, parameters, keyHolder);
        return keyHolder.getKeyAs(Long.class);
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

    public static class RoomDetailedRowMapper implements RowMapper<DetailedRoom> {
        @Override
        public DetailedRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
            DetailedRoom detailedRoom = new DetailedRoom();
            Room room = (new BeanPropertyRowMapper<>(Room.class)).mapRow(rs,rowNum);
            RoomCategory roomCategory = (new BeanPropertyRowMapper<>(RoomCategory.class)).mapRow(rs,rowNum);
            detailedRoom.setRoom(room);
            detailedRoom.setRoomCategory(roomCategory);
            return detailedRoom;
        }
    }
}

