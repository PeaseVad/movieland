package com.pasechnik.movieland.service;

import com.pasechnik.movieland.dao.MovieDao;
import com.pasechnik.movieland.entity.Movie;
import com.pasechnik.movieland.entity.MovieWithDescription;
import com.pasechnik.movieland.entity.Country;
import com.pasechnik.movieland.entity.Genre;
import com.pasechnik.movieland.entity.User;
import com.pasechnik.movieland.entity.Review;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultMovieServiceTest {

    @Test
    public void testGetAll() {
        MovieDao movieDao = mock(MovieDao.class);

        List<Movie> expectedMovieList = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setNameRussian("Список Шиндлера");
        movie1.setNameNative("Schindler's List");
        movie1.setYearOfRelease("1993");
        movie1.setRating(8.7);
        movie1.setPrice(150.5);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId(2);
        movie2.setNameRussian("Пролетая над гнездом кукушки");
        movie2.setNameNative("One Flew Over the Cuckoo''s Nest");
        movie2.setYearOfRelease("1975");
        movie2.setRating(8.7);
        movie2.setPrice(180);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BZjA0OWVhOTAtYWQxNi00YzNhLWI4ZjYtNjFjZTEyYjJlNDVlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie2);

        DefaultMovieService movieService = new DefaultMovieService(movieDao);

        when(movieDao.getAll()).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.getAll();

        assertEquals(2, actualMovieList.size());

        for (Movie actualMovie : actualMovieList) {
            assertTrue(expectedMovieList.contains(actualMovie));
        }
    }

    @Test
    public void testGetThreeRandomMovies() {

        MovieDao movieDao = mock(MovieDao.class);

        List<Movie> expectedMovieList = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setNameRussian("Список Шиндлера");
        movie1.setNameNative("Schindler's List");
        movie1.setYearOfRelease("1993");
        movie1.setRating(8.7);
        movie1.setPrice(150.5);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId(2);
        movie2.setNameRussian("Пролетая над гнездом кукушки");
        movie2.setNameNative("One Flew Over the Cuckoo''s Nest");
        movie2.setYearOfRelease("1975");
        movie2.setRating(8.7);
        movie2.setPrice(180);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BZjA0OWVhOTAtYWQxNi00YzNhLWI4ZjYtNjFjZTEyYjJlNDVlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie2);

        DefaultMovieService movieService = new DefaultMovieService(movieDao);

        when(movieDao.getThreeRandomMovies()).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.getThreeRandomMovies();

        assertEquals(2, actualMovieList.size());

        for (Movie actualMovie : actualMovieList) {
            assertTrue(expectedMovieList.contains(actualMovie));
        }
    }

    @Test
    public void testGetMoviesByGenre() {

        MovieDao movieDao = mock(MovieDao.class);

        List<Movie> expectedMovieList = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setNameRussian("Список Шиндлера");
        movie1.setNameNative("Schindler's List");
        movie1.setYearOfRelease("1993");
        movie1.setRating(8.7);
        movie1.setPrice(150.5);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId(2);
        movie2.setNameRussian("Пролетая над гнездом кукушки");
        movie2.setNameNative("One Flew Over the Cuckoo''s Nest");
        movie2.setYearOfRelease("1975");
        movie2.setRating(8.7);
        movie2.setPrice(180);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BZjA0OWVhOTAtYWQxNi00YzNhLWI4ZjYtNjFjZTEyYjJlNDVlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie2);

        DefaultMovieService movieService = new DefaultMovieService(movieDao);

        when(movieDao.getMoviesByGenre(3)).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.getMoviesByGenre(3);

        assertEquals(2, actualMovieList.size());

        for (Movie actualMovie : actualMovieList) {
            assertTrue(expectedMovieList.contains(actualMovie));
        }
    }

    @Test
    public void testGetMovieById() {

        Country country = new Country(1, "США");
        List<Country> expectedCountryList = new ArrayList<>();
        expectedCountryList.add(country);

        DefaultCountryService defaultCountryService = mock(DefaultCountryService.class);
        when(defaultCountryService.getByMovieId(2)).thenReturn(expectedCountryList);

        Genre genre = new Genre(1, "драма");
        List<Genre> expectedGenreList = new ArrayList<>();
        expectedGenreList.add(genre);

        DefaultGenreService defaultGenreService = mock(DefaultGenreService.class);
        when(defaultGenreService.getByMovieId(2)).thenReturn(expectedGenreList);

        List<Review> expectedReviewList = new ArrayList<>();
        User user = new User(10, "dennis.craig82@example.com");
        Review review = new Review(32, user, "Скажу только одно — как я жалею, что не посмотрела его раньше!");
        expectedReviewList.add(review);

        DefaultReviewService defaultReviewService = mock(DefaultReviewService.class);
        when(defaultReviewService.getByMovieId(2)).thenReturn(expectedReviewList);

        MovieWithDescription expectedMovie = new MovieWithDescription();
        expectedMovie.setId(2);
        expectedMovie.setNameRussian("Пролетая над гнездом кукушки");
        expectedMovie.setNameNative("One Flew Over the Cuckoo''s Nest");
        expectedMovie.setYearOfRelease("1975");
        expectedMovie.setDescription("Сымитировав помешательство в надежде избежать тюремного заключения, Рэндл Патрик МакМерфи попадает в психиатрическую клинику, где почти безраздельным хозяином является жестокосердная сестра Милдред Рэтчед. МакМерфи поражается тому, что прочие пациенты смирились с существующим положением вещей, а некоторые — даже сознательно пришли в лечебницу, прячась от пугающего внешнего мира. И решается на бунт. В одиночку.");
        expectedMovie.setRating(8.7);
        expectedMovie.setPrice(180);
        expectedMovie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BZjA0OWVhOTAtYWQxNi00YzNhLWI4ZjYtNjFjZTEyYjJlNDVlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg");

        MovieDao movieDao = mock(MovieDao.class);

        DefaultMovieService movieService = new DefaultMovieService(movieDao);
        movieService.setCountryService(defaultCountryService);
        movieService.setGenreService(defaultGenreService);
        movieService.setReviewService(defaultReviewService);

        when(movieDao.getMovieById(2)).thenReturn(expectedMovie);

        MovieWithDescription actualMovie = movieService.getMovieById(2);

        assertEquals(expectedMovie.getId(), actualMovie.getId());
        assertEquals(expectedMovie.getNameRussian(), actualMovie.getNameRussian());
        assertEquals(expectedMovie.getNameNative(), actualMovie.getNameNative());
        assertEquals(expectedMovie.getYearOfRelease(), actualMovie.getYearOfRelease());
        assertEquals(expectedMovie.getDescription(), actualMovie.getDescription());
        assertEquals(expectedMovie.getRating(), actualMovie.getRating(), 0.1);
        assertEquals(expectedMovie.getPrice(), actualMovie.getPrice(), 0.1);
        assertEquals(expectedMovie.getPicturePath(), actualMovie.getPicturePath());
        assertEquals(expectedMovie.getCountries(), actualMovie.getCountries());
        assertEquals(expectedMovie.getGenres(), actualMovie.getGenres());
        assertEquals(expectedMovie.getReviews(), actualMovie.getReviews());
    }
}
