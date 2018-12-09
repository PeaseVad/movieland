package com.pasechnik.movieland.dao;

import com.pasechnik.movieland.common.RequestAdditionalParam;
import com.pasechnik.movieland.dao.mapper.MovieRowMapper;
import com.pasechnik.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao {

    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();
    private JdbcTemplate jdbcTemplate;
    private String getAllMoviesSQL;
    private String getRandomMoviesSQL;
    private String getMoviesByGenreSQL;

    @Override
    public List<Movie> getAll() {
        return jdbcTemplate.query(getAllMoviesSQL, MOVIE_ROW_MAPPER);
    }

    @Override
    public List<Movie> getThreeRandomMovies() {
        return jdbcTemplate.query(getRandomMoviesSQL, MOVIE_ROW_MAPPER);
    }

    @Override
    public List<Movie> getMoviesByGenre(int id) {
        return jdbcTemplate.query(getMoviesByGenreSQL, MOVIE_ROW_MAPPER, id);
    }

    @Override
    public List<Movie> getAll(RequestAdditionalParam requestAdditionalParam) {
        String getAllMoviesWithSortingSQL = SQLGenerator.addSortingToSQL(getAllMoviesSQL, requestAdditionalParam);
        return jdbcTemplate.query(getAllMoviesWithSortingSQL, MOVIE_ROW_MAPPER);
    }

    @Override
    public List<Movie> getMoviesByGenre(int id, RequestAdditionalParam requestAdditionalParam) {
        String getMoviesByGenreWithSortingSQL = SQLGenerator.addSortingToSQL(getMoviesByGenreSQL, requestAdditionalParam);
        return jdbcTemplate.query(getMoviesByGenreWithSortingSQL, MOVIE_ROW_MAPPER, id);
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

    @Autowired
    public void setGetMoviesByGenreSQL(String getMoviesByGenreSQL) {
        this.getMoviesByGenreSQL = getMoviesByGenreSQL;
    }
}
