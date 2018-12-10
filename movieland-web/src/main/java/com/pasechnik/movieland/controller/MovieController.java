package com.pasechnik.movieland.controller;

import com.pasechnik.movieland.common.RequestAdditionalParam;
import com.pasechnik.movieland.common.SortField;
import com.pasechnik.movieland.common.SortType;
import com.pasechnik.movieland.common.SortTypeConverter;
import com.pasechnik.movieland.entity.Movie;
import com.pasechnik.movieland.entity.MovieWithDescription;
import com.pasechnik.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, path = "movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public ResponseEntity getAllMovies(@RequestParam(name = "rating", required = false) SortType ratingOrder, @RequestParam(name = "price", required = false) SortType priceOrder) {

        // Wrong params for request
        if ((ratingOrder != null && priceOrder != null) || (ratingOrder != null && ratingOrder.equals(SortType.ASC))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
        }

        // Get all movies
        if (ratingOrder == null && priceOrder == null) {
            return ResponseEntity.ok(movieService.getAll());
        }

        // Get all movies with sorting
        RequestAdditionalParam requestAdditionalParam = new RequestAdditionalParam();

        if (ratingOrder != null) {
            requestAdditionalParam.setSortField(SortField.RATING);
            requestAdditionalParam.setSortType(ratingOrder);
        }

        if (priceOrder != null) {
            requestAdditionalParam.setSortField(SortField.PRICE);
            requestAdditionalParam.setSortType(priceOrder);
        }
        return ResponseEntity.ok(movieService.getAll(requestAdditionalParam));
    }

    @RequestMapping(method = RequestMethod.GET, path = "movie/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getThreeRandomMovies() {
        return movieService.getThreeRandomMovies();
    }

    @RequestMapping(method = RequestMethod.GET, path = "movie/genre/{genreId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public ResponseEntity getMoviesByGenre(@PathVariable("genreId") int id, @RequestParam(name = "rating", required = false) SortType ratingOrder, @RequestParam(name = "price", required = false) SortType priceOrder) {

        // Wrong params for request
        if ((ratingOrder != null && priceOrder != null) || (ratingOrder != null && ratingOrder.equals(SortType.ASC))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
        }

        // Get all movies
        if (ratingOrder == null && priceOrder == null) {
            return ResponseEntity.ok(movieService.getMoviesByGenre(id));
        }

        // Get all movies with sorting
        RequestAdditionalParam requestAdditionalParam = new RequestAdditionalParam();

        if (ratingOrder != null) {
            requestAdditionalParam.setSortField(SortField.RATING);
            requestAdditionalParam.setSortType(ratingOrder);
        }

        if (priceOrder != null) {
            requestAdditionalParam.setSortField(SortField.PRICE);
            requestAdditionalParam.setSortType(priceOrder);
        }

        return ResponseEntity.ok(movieService.getMoviesByGenre(id, requestAdditionalParam));
    }

    @RequestMapping(method = RequestMethod.GET, path = "movie/{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MovieWithDescription getMovieById(@PathVariable("movieId") int id) {
        return movieService.getMovieById(id);
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(SortType.class, new SortTypeConverter());
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}
