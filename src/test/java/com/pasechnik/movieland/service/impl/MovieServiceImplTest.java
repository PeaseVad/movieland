package com.pasechnik.movieland.service.impl;

import com.pasechnik.movieland.dao.MovieDao;
import com.pasechnik.movieland.entity.Movie;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieServiceImplTest {

    @Test
    public void getAll() {
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

        MovieServiceImpl movieService = new MovieServiceImpl();
        movieService.setMovieDao(movieDao);

        when(movieDao.getAll()).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.getAll();

        assertEquals(2, actualMovieList.size());

        Movie actual1 = actualMovieList.get(0);
        Movie expected1 = expectedMovieList.get(0);
        assertEquals(expected1.getId(),actual1.getId());
        assertEquals(expected1.getNameRussian(),actual1.getNameRussian());
        assertEquals(expected1.getNameNative(),actual1.getNameNative());
        assertEquals(expected1.getYearOfRelease(),actual1.getYearOfRelease());
        assertEquals(expected1.getRating(),actual1.getRating(),0.1);
        assertEquals(expected1.getPrice(),actual1.getPrice(),0.1);
        assertEquals(expected1.getPicturePath(),actual1.getPicturePath());

        Movie actual2 = actualMovieList.get(1);
        Movie expected2 = expectedMovieList.get(1);
        assertEquals(expected2.getId(),actual2.getId());
        assertEquals(expected2.getNameRussian(),actual2.getNameRussian());
        assertEquals(expected2.getNameNative(),actual2.getNameNative());
        assertEquals(expected2.getYearOfRelease(),actual2.getYearOfRelease());
        assertEquals(expected2.getRating(),actual2.getRating(),0.1);
        assertEquals(expected2.getPrice(),actual2.getPrice(),0.1);
        assertEquals(expected2.getPicturePath(),actual2.getPicturePath());
    }
    }
