package hr.fer.zpr.infsus.backend.repository;

import hr.fer.zpr.infsus.backend.model.OvernightStay;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OvernightStayRepository {

    private final NamedParameterJdbcTemplate njdbc;

    public OvernightStayRepository(@Qualifier("NamedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
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

    public boolean updateOvernightStay(OvernightStay reservartion) {
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
        parameters.addValue("roomId", reservartion.getRoomId());
        parameters.addValue("overnightStayDateFrom", reservartion.getOvernightStayDateFrom());
        parameters.addValue("overnightStayDateTo", reservartion.getOvernightStayDateTo());
        parameters.addValue("overnightStayStatusId", reservartion.getOvernightStayStatusId());

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
