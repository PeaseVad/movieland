package com.pasechnik.movieland.dao.jdbc;

import com.pasechnik.movieland.dao.MovieDao;
import com.pasechnik.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.pasechnik.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao {

    private JdbcTemplate jdbcTemplate;
    private String getAllMoviesSQL;
    private String getRandomMoviesSQL;

    @Override
    public List<Movie> getAll() {
        return jdbcTemplate.query(getAllMoviesSQL, new MovieRowMapper());
    }

    @Override
    public List<Movie> getThreeRandomMovies() {
        return jdbcTemplate.query(getRandomMoviesSQL, new MovieRowMapper());
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setGetAllMoviesSQL(String getAllMoviesSQL) {
        this.getAllMoviesSQL = getAllMoviesSQL;
    }

    @Autowired
    public void setGetRandomMoviesSQL(String getRandomMoviesSQL) {
        this.getRandomMoviesSQL = getRandomMoviesSQL;
    }
}
