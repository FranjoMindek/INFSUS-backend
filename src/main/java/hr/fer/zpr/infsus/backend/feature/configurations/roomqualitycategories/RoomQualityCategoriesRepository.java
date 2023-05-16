package hr.fer.zpr.infsus.backend.feature.configurations.roomqualitycategories;

import hr.fer.zpr.infsus.backend.feature.codebooks.data.Codebook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomQualityCategoriesRepository {
    private final NamedParameterJdbcTemplate njdbc;

    public RoomQualityCategoriesRepository(@Qualifier("NamedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    public List<Codebook> getRoomQualityCategories() {
        String query = """
                SELECT
                    room_quality_category_id AS id,
                    room_quality_category_name AS name
                FROM room_quality_category
                """;
        return this.njdbc.query(query, BeanPropertyRowMapper.newInstance(Codebook.class));
    }

    public boolean insertRoomQualityCategory(Codebook roomQualityCategory) {
        String query = """
                INSERT INTO 
                    room_quality_category (room_quality_category_id, room_quality_category_name)
                VALUES 
                    (:id, :name)
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", roomQualityCategory.getId());
        parameters.addValue("name", roomQualityCategory.getName());

        return this.njdbc.update(query, parameters) > 0; // key == id, because it's a store
    }

    public boolean deleteRoomQualityCategory(String id) {
        String query = """
                DELETE FROM
                    room_quality_category
                WHERE
                    room_quality_category_id = :id
                """;
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", id);

        return this.njdbc.update(query, parameterSource) > 0;
    }
}
