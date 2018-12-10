package com.pasechnik.movieland.dao;

import com.pasechnik.movieland.dao.mapper.CountryRowMapper;
import com.pasechnik.movieland.entity.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcCountryDao implements CountryDao {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final CountryRowMapper COUNTRY_ROW_MAPPER = new CountryRowMapper();
    private JdbcTemplate jdbcTemplate;
    private String getCountryByMovieIdSQL;

    @Override
    public List<Country> getByMovieId(int id) {
        return jdbcTemplate.query(getCountryByMovieIdSQL, COUNTRY_ROW_MAPPER, id);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setGetCountryByMovieIdSQL(String getCountryByMovieIdSQL) {
        this.getCountryByMovieIdSQL = getCountryByMovieIdSQL;
    }
}
