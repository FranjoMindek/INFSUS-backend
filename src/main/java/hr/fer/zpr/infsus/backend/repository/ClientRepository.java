package hr.fer.zpr.infsus.backend.repository;

import hr.fer.zpr.infsus.backend.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ClientRepository {

    private final NamedParameterJdbcTemplate njdbc;

    public ClientRepository(@Qualifier("NamedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
        this.njdbc = njdbc;
    }

    public List<Client> getClients() {
        String query = """
                SELECT 
                    *
                FROM 
                    client
                """;

        return njdbc.query(query, BeanPropertyRowMapper.newInstance(Client.class));
    }

    public Client getClientById(Long clientId) {
        String query = """
                SELECT 
                    *
                FROM 
                    client
                WHERE 
                    client_id = :clientId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource("clientId", clientId);

        return njdbc.queryForObject(query, parameters, BeanPropertyRowMapper.newInstance(Client.class));
    }

    public boolean updateClient(Client client) {
        String query = """
                UPDATE 
                    client
                SET
                    client_first_name = :clientFirstName,
                    client_last_name = :clientLastName
                WHERE
                    client_id = :clientId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("clientId", client.getClientId());
        parameters.addValue("clientFirstName", client.getClientFirstName());
        parameters.addValue("clientLastName", client.getClientLastName());

        return njdbc.update(query, parameters) > 0;
    }

    public boolean deleteClient(Long clientId) {
        String query = """
                DELETE
                FROM
                    client
                WHERE
                    client_id = :clientId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource("clientId", clientId);

        return njdbc.update(query, parameters) > 0;
    }

}
