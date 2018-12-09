package com.pasechnik.movieland.dao.mapper;

import com.pasechnik.movieland.entity.MovieWithDescription;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieWithDescriptionRowMapper implements RowMapper<MovieWithDescription> {
    @Override
    public MovieWithDescription mapRow(ResultSet resultSet, int i) throws SQLException {
        MovieWithDescription movieWithDescription = new MovieWithDescription();
        movieWithDescription.setId(resultSet.getInt("id"));
        movieWithDescription.setNameRussian(resultSet.getString("movie_name_rus"));
        movieWithDescription.setNameNative(resultSet.getString("movie_name_native"));
        movieWithDescription.setYearOfRelease(resultSet.getString("release_date"));
        movieWithDescription.setDescription(resultSet.getString("storyline"));
        movieWithDescription.setRating(resultSet.getDouble("rating"));
        movieWithDescription.setPrice(resultSet.getDouble("price"));
        movieWithDescription.setPicturePath(resultSet.getString("poster"));
        return movieWithDescription;
    }
}



