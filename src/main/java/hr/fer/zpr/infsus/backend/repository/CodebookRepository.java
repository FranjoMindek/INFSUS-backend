package hr.fer.zpr.infsus.backend.repository;

import hr.fer.zpr.infsus.backend.model.Codebook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodebookRepository {

    private final NamedParameterJdbcTemplate njdbc;

    public CodebookRepository(@Qualifier("NamedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    public List<Codebook> getCodebookTemplate(String table, String id, String name) {
        String query = " SELECT " + id + " as id, " + name + " as name FROM " + table;
        return this.njdbc.query(query, BeanPropertyRowMapper.newInstance(Codebook.class));
    }

    public List<Codebook> getCodebookTemplate(String table, String id, String name, String where) {
        String query = " SELECT " + id + " as id, " + name + " as name FROM " + table + " WHERE " + where;
        return this.njdbc.query(query, BeanPropertyRowMapper.newInstance(Codebook.class));
    }

}
