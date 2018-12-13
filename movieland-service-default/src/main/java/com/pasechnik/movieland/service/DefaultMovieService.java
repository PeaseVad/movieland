package com.pasechnik.movieland.service;

import com.pasechnik.movieland.common.RequestAdditionalParam;
import com.pasechnik.movieland.dao.MovieDao;
import com.pasechnik.movieland.entity.Movie;
import com.pasechnik.movieland.entity.MovieWithDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DefaultMovieService implements MovieService {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private MovieDao movieDao;
    private CountryService countryService;
    private GenreService genreService;
    private ReviewService reviewService;
    private CurrencyService currencyService;

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

    @Override
    public List<Movie> getMoviesByGenre(int id) {
        List<Movie> movieList = movieDao.getMoviesByGenre(id);
        logger.debug("getMoviesByGenre returned {} rows", movieList.size());
        return movieList;
    }

    @Override
    public List<Movie> getAll(RequestAdditionalParam requestAdditionalParam) {
        return movieDao.getAll(requestAdditionalParam);
    }

    @Override
    public List<Movie> getMoviesByGenre(int id, RequestAdditionalParam requestAdditionalParam) {
        return movieDao.getMoviesByGenre(id, requestAdditionalParam);
    }

    @Override
    public MovieWithDescription getMovieById(int id) {
        MovieWithDescription movieWithDescription = movieDao.getMovieById(id);
        movieWithDescription.setCountries(countryService.getByMovieId(id));
        movieWithDescription.setGenres(genreService.getByMovieId(id));
        movieWithDescription.setReviews(reviewService.getByMovieId(id));
        return movieWithDescription;
    }

    @Override
    public MovieWithDescription getMovieById(int id, RequestAdditionalParam requestAdditionalParam) {

        MovieWithDescription movieWithDescription = movieDao.getMovieById(id);

        double rate = currencyService.getRateByCurrency(requestAdditionalParam.getCurrencyType());
        double currencyPrice = movieWithDescription.getPrice() / rate;
        movieWithDescription.setPrice(currencyPrice);
        movieWithDescription.setCountries(countryService.getByMovieId(id));
        movieWithDescription.setGenres(genreService.getByMovieId(id));
        movieWithDescription.setReviews(reviewService.getByMovieId(id));
        return movieWithDescription;
    }

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Autowired
    public void setCurrencyService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }
}
