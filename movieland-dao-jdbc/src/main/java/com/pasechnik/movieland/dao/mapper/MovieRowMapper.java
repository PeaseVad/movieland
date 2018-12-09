package com.pasechnik.movieland.dao.mapper;

import com.pasechnik.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("id"));
        movie.setNameRussian(resultSet.getString("movie_name_rus"));
        movie.setNameNative(resultSet.getString("movie_name_native"));
        movie.setYearOfRelease(resultSet.getString("release_date"));
        movie.setRating(resultSet.getDouble("rating"));
        movie.setPrice(resultSet.getDouble("price"));
        movie.setPicturePath(resultSet.getString("poster"));
        return movie;
    }
}



