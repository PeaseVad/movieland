package com.pasechnik.movieland.dao;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.pasechnik.movieland", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.pasechnik.movieland.controller.*"))
@ImportResource("classpath:/spring/query-context.xml")
public class TestDaoConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:db/create-db.sql")
                .addScript("classpath:db/insert-data.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
