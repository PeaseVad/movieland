package com.pasechnik.movieland.dao;

import com.pasechnik.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();

    List<Movie> getThreeRandomMovies();
}
