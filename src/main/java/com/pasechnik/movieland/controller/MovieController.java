package com.pasechnik.movieland.controller;


import com.pasechnik.movieland.entity.Movie;
import com.pasechnik.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Movie> getAllMovies() {
       return movieService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/movie/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Movie> getThreeRandomMovies() {
        return movieService.getThreeRandomMovies();
    }
}
