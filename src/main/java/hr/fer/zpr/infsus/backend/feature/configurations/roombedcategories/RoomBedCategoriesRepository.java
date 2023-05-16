package hr.fer.zpr.infsus.backend.feature.configurations.roombedcategories;

import hr.fer.zpr.infsus.backend.feature.codebooks.data.Codebook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomBedCategoriesRepository {
    private final NamedParameterJdbcTemplate njdbc;

    public RoomBedCategoriesRepository(@Qualifier("NamedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    public List<Codebook> getRoomBedCategories() {
        String query = """
                SELECT
                    room_bed_category_id,
                    room_bed_category_name
                FROM 
                    room_bed_category
                """;
        return this.njdbc.query(query, BeanPropertyRowMapper.newInstance(Codebook.class));
    }

    public boolean insertRoomBedCategory(Codebook roomBedCategory) {
        String query = """
                INSERT INTO 
                    room_bed_category (room_bed_category_id, room_bed_category_name)
                VALUES 
                    (:id, :name)
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", roomBedCategory.getId());
        parameters.addValue("name", roomBedCategory.getName());

        return this.njdbc.update(query, parameters) > 0; // key == id, because it's a store
    }

    public boolean deleteRoomBedCategory(String id) {
        String query = """
                DELETE FROM
                    room_bed_category
                WHERE
                    room_bed_category_id = :id
                """;
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", id);

        return this.njdbc.update(query, parameterSource) > 0;
    }
}
