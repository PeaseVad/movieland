package com.pasechnik.movieland.dao.jdbc;

import com.pasechnik.movieland.dao.MovieDao;
import com.pasechnik.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.pasechnik.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllMoviesSQL;


    @Override
    public List<Movie> getAll() {
        try {
            return jdbcTemplate.query(getAllMoviesSQL, new MovieRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
