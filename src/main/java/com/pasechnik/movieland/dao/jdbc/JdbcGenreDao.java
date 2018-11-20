package com.pasechnik.movieland.dao.jdbc;

import com.pasechnik.movieland.dao.GenreDao;
import com.pasechnik.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.pasechnik.movieland.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreDao implements GenreDao {
    private JdbcTemplate jdbcTemplate;
    private String getAllGenresSQL;

    @Override
    public List<Genre> getAll() {
        return jdbcTemplate.query(getAllGenresSQL, new GenreRowMapper());
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setGetAllGenresSQL(String getAllGenresSQL) {
        this.getAllGenresSQL = getAllGenresSQL;
    }
}
