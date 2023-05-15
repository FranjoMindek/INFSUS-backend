package hr.fer.zpr.infsus.backend.features.codebooks;

import hr.fer.zpr.infsus.backend.features.codebooks.data.Codebook;
import hr.fer.zpr.infsus.backend.features.codebooks.data.CodebookEnum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodebooksRepository {

    private final NamedParameterJdbcTemplate njdbc;

    public CodebooksRepository(@Qualifier("NamedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    public List<Codebook> getCodebookTemplate(String table, String id, String name) {
        String query = " SELECT " + id + " as id, " + name + " as name FROM " + table;
        return this.njdbc.query(query, BeanPropertyRowMapper.newInstance(Codebook.class));
    }

    public List<Codebook> getCodebookTemplate(String table, String id, String name, String where) {
        String query = " SELECT " + id + " as id, " + name + " as name FROM " + table;
        if (where != null) query += " WHERE " + where;
        return this.njdbc.query(query, BeanPropertyRowMapper.newInstance(Codebook.class));
    }
    public List<Codebook> getCodebookTemplate(CodebookEnum codebookEnum) {
        String query = " SELECT " + codebookEnum.getId() + " as id, " + codebookEnum.getName() + " as name FROM " + codebookEnum.getTable();
        if (codebookEnum.getWhere() != null) query += " WHERE " + codebookEnum.getWhere();
        return this.njdbc.query(query, BeanPropertyRowMapper.newInstance(Codebook.class));
    }

}
