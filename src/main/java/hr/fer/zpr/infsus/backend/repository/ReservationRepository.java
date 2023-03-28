package hr.fer.zpr.infsus.backend.repository;

import hr.fer.zpr.infsus.backend.model.Reservation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ReservationRepository {

    private final NamedParameterJdbcTemplate njdbc;

    public ReservationRepository(@Qualifier("NamedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    public List<Reservation> getReservations() {
        String query = """
                SELECT
                    *
                FROM
                    reservation
                """;

        return njdbc.query(query, BeanPropertyRowMapper.newInstance(Reservation.class));
    }

    public Reservation getReservationById(Long reservationId) {
        String query = """
                SELECT
                    *
                FROM
                    reservation
                WHERE
                    reservation_id = :reservationId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource("reservationId", reservationId);

        return njdbc.queryForObject(query, parameters, BeanPropertyRowMapper.newInstance(Reservation.class));
    }

    public boolean updateReservation(Reservation reservartion) {
        String query = """
                UPDATE
                    reservation
                SET
                    room_id = :roomId,
                    reservation_date_from = :reservationDateFrom,
                    reservation_date_to = :reservationDateTo,
                    reservation_status_id = :reservationStatusId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("roomId", reservartion.getRoomId());
        parameters.addValue("reservationDateFrom", reservartion.getReservationDateFrom());
        parameters.addValue("reservationDateTo", reservartion.getReservationDateTo());
        parameters.addValue("reservationStatusId", reservartion.getReservationStatusId());

        return njdbc.update(query, parameters) > 0;
    }

    public boolean deleteReservation(Long reservationId) {
        String query = """
                DELETE
                FROM
                    reservation
                WHERE
                    reservation_id = :reservationId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource("reservationId", reservationId);

        return njdbc.update(query, parameters) > 0;
    }

}
