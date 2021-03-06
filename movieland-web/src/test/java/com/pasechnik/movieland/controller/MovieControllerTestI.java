package com.pasechnik.movieland.controller;


import com.pasechnik.movieland.controller.config.MVCConfig;
import com.pasechnik.movieland.controller.config.RootConfig;
import com.pasechnik.movieland.dao.MovieDao;
import com.pasechnik.movieland.entity.Movie;
import com.pasechnik.movieland.entity.MovieWithDescription;
import com.pasechnik.movieland.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, MVCConfig.class})
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class MovieControllerTestI extends AbstractJUnit4SpringContextTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    @InjectMocks
    MovieService movieService;

    @Mock
    MovieDao movieDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.webApplicationContext);
        this.mockMvc = builder.build();
    }

    @Test
    public void testGetAll() throws Exception {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setNameRussian("Список Шиндлера");
        movie.setNameNative("Schindler's List");
        movie.setYearOfRelease("1900");
        movie.setRating(8.7);
        movie.setPrice(150.5);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");

        // When
        when(movieService.getAll()).thenReturn(Collections.singletonList(movie));

        // Then
        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Список Шиндлера")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Schindler's List")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo("1900")))
                .andExpect(jsonPath("$[0].rating", equalTo(8.7)))
                .andExpect(jsonPath("$[0].price", equalTo(150.5)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg")));
    }

    @Test
    public void testGetThreeRandomMovies() throws Exception {

        Movie movie = new Movie();
        movie.setId(1);
        movie.setNameRussian("Список Шиндлера");
        movie.setNameNative("Schindler's List");
        movie.setYearOfRelease("1900");
        movie.setRating(8.7);
        movie.setPrice(150.5);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");

        // When
        when(movieService.getThreeRandomMovies()).thenReturn(Collections.singletonList(movie));

        // Then
        mockMvc.perform(get("/movie/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Список Шиндлера")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Schindler's List")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo("1900")))
                .andExpect(jsonPath("$[0].rating", equalTo(8.7)))
                .andExpect(jsonPath("$[0].price", equalTo(150.5)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg")));
    }

    @Test
    public void testGetMoviesByGenre() throws Exception {

        Movie movie = new Movie();
        movie.setId(1);
        movie.setNameRussian("Список Шиндлера");
        movie.setNameNative("Schindler's List");
        movie.setYearOfRelease("1900");
        movie.setRating(8.7);
        movie.setPrice(150.5);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");

        // When
        when(movieService.getMoviesByGenre(3)).thenReturn(Collections.singletonList(movie));

        // Then
        mockMvc.perform(get("/movie/genre/3"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Список Шиндлера")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Schindler's List")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo("1900")))
                .andExpect(jsonPath("$[0].rating", equalTo(8.7)))
                .andExpect(jsonPath("$[0].price", equalTo(150.5)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg")));
    }

    @Test
    public void testGetMoviesByGenreWithSort() throws Exception {

        mockMvc.perform(get("/movie/genre/3?rating=asc"))
                .andExpect(status().isBadRequest());

        mockMvc.perform(get("/movie/genre/3?rating=desc&price=asc"))
                .andExpect(status().isBadRequest());

        mockMvc.perform(get("/movie/genre/3?price=desc"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/movie/genre/3?rating=desc"))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetMoviesWithSort() throws Exception {

        mockMvc.perform(get("/movie?rating=asc"))
                .andExpect(status().isBadRequest());

        mockMvc.perform(get("/movie?rating=desc&price=asc"))
                .andExpect(status().isBadRequest());

        mockMvc.perform(get("/movie?price=desc"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/movie?rating=desc"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMovieById() throws Exception {
        MovieWithDescription movie = new MovieWithDescription();
        movie.setId(1);
        movie.setNameRussian("Список Шиндлера");
        movie.setNameNative("Schindler's List");
        movie.setYearOfRelease("1900");
        movie.setDescription("Сымитировав помешательство в надежде избежать тюремного заключения, Рэндл Патрик МакМерфи попадает в психиатрическую клинику, где почти безраздельным хозяином является жестокосердная сестра Милдред Рэтчед. МакМерфи поражается тому, что прочие пациенты смирились с существующим положением вещей, а некоторые — даже сознательно пришли в лечебницу, прячась от пугающего внешнего мира. И решается на бунт. В одиночку.");
        movie.setRating(8.7);
        movie.setPrice(150.5);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");

        // When
        when(movieDao.getMovieById(2)).thenReturn(movie);

        mockMvc.perform(get("/movie/2"))
                .andExpect(status().isOk());
    }
}
