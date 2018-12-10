package com.pasechnik.movieland.service;

import com.pasechnik.movieland.common.RequestAdditionalParam;
import com.pasechnik.movieland.entity.Movie;
import com.pasechnik.movieland.entity.MovieWithDescription;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    List<Movie> getThreeRandomMovies();

    List<Movie> getMoviesByGenre(int id);

    List<Movie> getAll(RequestAdditionalParam requestAdditionalParam);

    List<Movie> getMoviesByGenre(int id, RequestAdditionalParam requestAdditionalParam);

    MovieWithDescription getMovieById(int id);
}
