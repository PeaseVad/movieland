package com.pasechnik.movieland.controller;

import com.pasechnik.movieland.entity.Movie;
import com.pasechnik.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, path = "movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getAllMovies() {
        return movieService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "movie/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getThreeRandomMovies() {
        return movieService.getThreeRandomMovies();
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}
