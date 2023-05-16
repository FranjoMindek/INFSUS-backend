package hr.fer.zpr.infsus.backend.feature.clients;

import hr.fer.zpr.infsus.backend.feature.clients.data.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientsRepository {

    private final NamedParameterJdbcTemplate njdbc;

    public ClientsRepository(@Qualifier("NamedParameterJdbcTemplate") NamedParameterJdbcTemplate njdbc) {
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

    public Client getClientByNationalId(String clientNationalId) {
        String query = """
                SELECT 
                    *
                FROM 
                    client
                WHERE 
                    client_national_id = :clientNationalId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource("clientNationalId", clientNationalId);

        List<Client> result = njdbc.query(query, parameters, BeanPropertyRowMapper.newInstance(Client.class));
        return result.size() > 0 ? result.get(0) : null;
    }

    public Long insertClient(String clientNationalId, String clientPhoneNumber, String clientFirstName, String clientLastName) {
        String query = """
                INSERT INTO 
                    client (client_national_id, client_phone_number, client_first_name, client_last_name)
                VALUES 
                    (:clientNationalId, :clientPhoneNumber, :clientFirstName, :clientLastName)
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("clientNationalId", clientNationalId);
        parameters.addValue("clientPhoneNumber", clientPhoneNumber);
        parameters.addValue("clientFirstName", clientFirstName);
        parameters.addValue("clientLastName", clientLastName);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        njdbc.update(query, parameters, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public Long insertClient(Client client) {
        String query = """
                INSERT INTO 
                    client (client_national_id, client_phone_number, client_first_name, client_last_name)
                VALUES 
                    (:clientNationalId, :clientPhoneNumber, :clientFirstName, :clientLastName)
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("clientNationalId", client.getClientNationalId());
        parameters.addValue("clientPhoneNumber", client.getClientPhoneNumber());
        parameters.addValue("clientFirstName", client.getClientFirstName());
        parameters.addValue("clientLastName", client.getClientLastName());
        KeyHolder keyHolder = new GeneratedKeyHolder();

        njdbc.update(query, parameters, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public boolean updateClient(Client client) {
        String query = """
                UPDATE 
                    client
                SET
                    client_phone_number = :clientPhoneNumber,
                    client_first_name = :clientFirstName,
                    client_last_name = :clientLastName
                WHERE
                    client_id = :clientId
                """;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("clientId", client.getClientId());
        parameters.addValue("clientPhoneNumber", client.getClientPhoneNumber());
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
