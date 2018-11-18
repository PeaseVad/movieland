package com.pasechnik.movieland.controller;


import com.pasechnik.movieland.entity.Movie;
import com.pasechnik.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, path = "/movie", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Movie> getAllMovies() {
       return movieService.getAll();

    }




}
