package com.pasechnik.movieland.controller;

import com.pasechnik.movieland.entity.Genre;
import com.pasechnik.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {

    private GenreService genreService;

    @RequestMapping(method = RequestMethod.GET, path = "genre", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Genre> getAllGenres() {
        return genreService.getAll();
    }

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }
}
