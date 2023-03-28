package hr.fer.zpr.infsus.backend.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("PrimaryDS")
    @Primary
    @ConfigurationProperties("spring.datasource.hikari")
    public HikariDataSource primaryHikariDataSource() {
        return primaryDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean("PrimaryJdbcTemplate")
    @Primary
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("PrimaryDS") DataSource ds) {
        JdbcTemplate template = new JdbcTemplate(ds);
        template.setQueryTimeout(120);
        return template;
    }

    @Bean("NamedParameterJdbcTemplate")
    @Primary
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("PrimaryDS") DataSource ds) {
        JdbcTemplate template = new JdbcTemplate(ds);
        template.setQueryTimeout(120);
        return new NamedParameterJdbcTemplate(template);

    }

}
