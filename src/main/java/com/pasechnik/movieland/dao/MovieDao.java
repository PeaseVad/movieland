package com.pasechnik.movieland.dao;

import com.pasechnik.common.RequestAdditionalParam;
import com.pasechnik.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();

    List<Movie> getThreeRandomMovies();

    List<Movie> getMoviesByGenre(int id);

    List<Movie> getAll(RequestAdditionalParam requestAdditionalParam);

    List<Movie> getMoviesByGenre(int id, RequestAdditionalParam requestAdditionalParam);
}
