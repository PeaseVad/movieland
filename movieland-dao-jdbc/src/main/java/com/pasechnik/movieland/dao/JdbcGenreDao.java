package com.pasechnik.movieland.dao;

import com.pasechnik.movieland.dao.mapper.GenreRowMapper;
import com.pasechnik.movieland.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreDao implements GenreDao {
    private static final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();
    private JdbcTemplate jdbcTemplate;
    private String getAllGenresSQL;
    private String getGenreByMovieIdSQL;

    @Override
    public List<Genre> getAll() {
        return jdbcTemplate.query(getAllGenresSQL, GENRE_ROW_MAPPER);
    }

    @Override
    public List<Genre> getByMovieId(int id) {
        return jdbcTemplate.query(getGenreByMovieIdSQL, GENRE_ROW_MAPPER, id);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setGetAllGenresSQL(String getAllGenresSQL) {
        this.getAllGenresSQL = getAllGenresSQL;
    }

    @Autowired
    public void setGetGenreByMovieIdSQL(String getGenreByMovieIdSQL) {
        this.getGenreByMovieIdSQL = getGenreByMovieIdSQL;
    }
}
