package hr.fer.zpr.infsus.backend.feature.overnightstays;

import hr.fer.zpr.infsus.backend.feature.overnightstays.model.OvernightStay;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OvernightStaysRepository {

    private final NamedParameterJdbcTemplate njdbc;

    public OvernightStaysRepository(@Qualifier("NamedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }


    public List<OvernightStay> getOvernightStays() {
        String query = """
                SELECT
                    *
                FROM
                    overnight_stay
                """;

        return njdbc.query(query, BeanPropertyRowMapper.newInstance(OvernightStay.class));
    }

    public OvernightStay getOvernightStayById(Long overnightStayId) {
        String query = """
                SELECT
                    *
                FROM
                    overnight_stay
                WHERE
                    overnight_stay_id = :overnightStayId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource("overnightStayId", overnightStayId);

        return njdbc.queryForObject(query, parameters, BeanPropertyRowMapper.newInstance(OvernightStay.class));
    }

    public Long insertOvernightStay(OvernightStay overnightStay) {
        String query = """
                INSERT INTO
                    overnight_stay (client_id, room_id, overnight_stay_date_from, overnight_stay_date_to, overnight_stay_status_id)
                VALUES 
                    (:clientId, :roomId, :overnightStayDateFrom, :overnightStayDateTo, :overnightStayStatusId)
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("clientId", overnightStay.getClientId());
        parameters.addValue("roomId", overnightStay.getRoomId());
        parameters.addValue("overnightStayDateFrom", overnightStay.getOvernightStayDateFrom());
        parameters.addValue("overnightStayDateTo", overnightStay.getOvernightStayDateTo());
        parameters.addValue("overnightStayStatusId", "OVERNIGHT_STAY_STATUS.PENDING");
        KeyHolder keyHolder = new GeneratedKeyHolder();

        njdbc.update(query, parameters, keyHolder);
        return keyHolder.getKeyAs(Long.class);
    }

    public boolean updateOvernightStay(OvernightStay overnightStay) {
        String query = """
                UPDATE
                    overnight_stay
                SET
                    room_id = :roomId,
                    overnight_stay_date_from = :overnightStayDateFrom,
                    overnight_stay_date_to = :overnightStayDateTo,
                    overnight_stay_status_id = :overnightStayStatusId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("roomId", overnightStay.getRoomId());
        parameters.addValue("overnightStayDateFrom", overnightStay.getOvernightStayDateFrom());
        parameters.addValue("overnightStayDateTo", overnightStay.getOvernightStayDateTo());
        parameters.addValue("overnightStayStatusId", overnightStay.getOvernightStayStatusId());

        return njdbc.update(query, parameters) > 0;
    }

    public boolean deleteOvernightStay(Long overnightStayId) {
        String query = """
                DELETE
                FROM
                    overnight_stay
                WHERE
                    overnight_stay_id = :overnightStayId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource("overnightStayId", overnightStayId);

        return njdbc.update(query, parameters) > 0;
    }
}
