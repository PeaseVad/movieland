package com.pasechnik.movieland.service;

import com.pasechnik.movieland.dao.MovieDao;
import com.pasechnik.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DefaultMovieService implements MovieService {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private MovieDao movieDao;

    @Autowired
    public DefaultMovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movieList = movieDao.getAll();
        logger.debug("getAll returned {} rows", movieList.size());
        return movieList;
    }

    @Override
    public List<Movie> getThreeRandomMovies() {
        List<Movie> movieList = movieDao.getThreeRandomMovies();
        logger.debug("getThreeRandomMovies returned {} rows", movieList.size());
        return movieList;
    }
}
