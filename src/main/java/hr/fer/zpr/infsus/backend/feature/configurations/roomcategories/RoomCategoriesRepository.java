package hr.fer.zpr.infsus.backend.feature.configurations.roomcategories;

import hr.fer.zpr.infsus.backend.feature.configurations.roomcategories.data.RoomCategory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomCategoriesRepository {
    private final NamedParameterJdbcTemplate njdbc;

    public RoomCategoriesRepository(@Qualifier("NamedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    public List<RoomCategory> getRoomCategories() {
        String query = """
                SELECT
                    room_category_id,
                    room_category_name,
                    room_category_price,
                    room_bed_category_id,
                    room_quality_category_id
                FROM
                    room_category
                """;
        return this.njdbc.query(query, BeanPropertyRowMapper.newInstance(RoomCategory.class));
    }

    public boolean insertUpdateRoomCategory(RoomCategory roomCategory) {
        String query = """
                INSERT INTO 
                    room_category (room_category_id, room_category_name, room_category_price, room_bed_category_id, room_quality_category_id)
                VALUES 
                    (:id, :name, :price, :roomBedCategory, :roomQualityCategory)
                ON CONFLICT (room_category_id) 
                    DO UPDATE 
                    SET
                        room_category_name = :name,
                        room_category_price = :price,
                        room_bed_category_id = :roomBedCategory,
                        room_quality_category_id = :roomQualityCategory
                        
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", roomCategory.getRoomCategoryId());
        parameters.addValue("name", roomCategory.getRoomCategoryName());
        parameters.addValue("price", roomCategory.getRoomCategoryPrice());
        parameters.addValue("roomBedCategory", roomCategory.getRoomBedCategoryId());
        parameters.addValue("roomQualityCategory", roomCategory.getRoomQualityCategoryId());

        return this.njdbc.update(query, parameters) > 0; // key == id, because it's a store
    }


// TODO: ali odustao jer intellij ne radi s novom psql merge sintaksom pa me malo zivcira, osim toga nije idalno kada se bas radi samo 1 insert/update

//    public boolean margeRoomCategory(RoomCategory roomCategory) {
//        String query = """
//                MERGE INTO
//                    room_category rc1
//                USING
//                    (SELECT :id, :name, :price, :roomBedCategory, :roomQualityCategory) AS rc2
//                ON
//                    rc1.room_category_id = rc2.room_category_id
//                WHEN MATCHED THEN
//                    UPDATE SET
//                        room_category_name = :name,
//                        room_category_price = :price,
//                        room_bed_category_id = :roomBedCategory,
//                        room_quality_category_id = :roomQualityCategory
//                WHEN NOT MATCHED THEN
//                    INSERT
//                        (room_category_id, room_category_name, room_category_price, room_bed_category_id, room_quality_category_id)
//                    VALUES
//                        (:id, :name, :price, :roomBedCategory, :roomQualityCategory)
//                """;
//        MapSqlParameterSource parameters = new MapSqlParameterSource();
//        parameters.addValue("id", roomCategory.getRoomCategoryId());
//        parameters.addValue("name", roomCategory.getRoomCategoryName());
//        parameters.addValue("price", roomCategory.getRoomCategoryPrice());
//        parameters.addValue("roomBedCategory", roomCategory.getRoomBedCategoryId());
//        parameters.addValue("roomQualityCategory", roomCategory.getRoomQualityCategoryId());
//
//        return this.njdbc.update(query, parameters) > 0; // key == id, because it's a store
//    }

    public boolean insertRoomCategory(RoomCategory roomCategory) {
        String query = """
                INSERT INTO 
                    room_category (room_category_id, room_category_name, room_category_price, room_bed_category_id, room_quality_category_id)
                VALUES 
                    (:id, :name, :price, :roomBedCategory, :roomQualityCategory)
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", roomCategory.getRoomCategoryId());
        parameters.addValue("name", roomCategory.getRoomCategoryName());
        parameters.addValue("price", roomCategory.getRoomCategoryPrice());
        parameters.addValue("roomBedCategory", roomCategory.getRoomBedCategoryId());
        parameters.addValue("roomQualityCategory", roomCategory.getRoomQualityCategoryId());

        return this.njdbc.update(query, parameters) > 0; // key == id, because it's a store
    }

    public boolean updateRoomCategory(RoomCategory roomCategory) {
        String query = """
                UPDATE
                    room_category
                SET
                    room_category_name = :name,
                    room_category_price = :price,
                    room_bed_category_id = :roomBedCategory,
                    room_quality_category_id = :roomQualityCategory
                WHERE
                    room_category_id = :id
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", roomCategory.getRoomCategoryId());
        parameters.addValue("name", roomCategory.getRoomCategoryName());
        parameters.addValue("price", roomCategory.getRoomCategoryPrice());
        parameters.addValue("roomBedCategory", roomCategory.getRoomBedCategoryId());
        parameters.addValue("roomQualityCategory", roomCategory.getRoomQualityCategoryId());

        return this.njdbc.update(query, parameters) > 0; // key == id, because it's a store
    }

    public boolean deleteRoomCategory(String id) {
        String query = """
                DELETE FROM
                    room_category
                WHERE
                    room_category_id = :id
                """;
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", id);

        return this.njdbc.update(query, parameterSource) > 0;
    }
}
