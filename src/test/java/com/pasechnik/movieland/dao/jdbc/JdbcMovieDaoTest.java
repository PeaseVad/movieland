
package com.pasechnik.movieland.dao.jdbc;

import com.pasechnik.movieland.dao.MovieDao;
import com.pasechnik.movieland.entity.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring/root-context.xml", "file:src/main/webapp/WEB-INF/movieland-servlet.xml", "classpath:/spring/test-context.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class JdbcMovieDaoTest {
    @Autowired
    private MovieDao movieDao;

    @Test
    public void testGetAll() {

        Movie expectedMovie = new Movie();
        expectedMovie.setId(1);
        expectedMovie.setNameRussian("Список Шиндлера");
        expectedMovie.setNameNative("Schindler's List");
        expectedMovie.setYearOfRelease("1993");
        expectedMovie.setRating(8.7);
        expectedMovie.setPrice(150.5);
        expectedMovie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");

        List<Movie> actualMovieList = movieDao.getAll();
        assertEquals(25, actualMovieList.size());

        int index = actualMovieList.indexOf(expectedMovie);
        Movie actualMovie = actualMovieList.get(index);

        assertEquals(expectedMovie.getId(), actualMovie.getId());
        assertEquals(expectedMovie.getNameRussian(), actualMovie.getNameRussian());
        assertEquals(expectedMovie.getNameNative(), actualMovie.getNameNative());
        assertEquals(expectedMovie.getYearOfRelease(), actualMovie.getYearOfRelease());
        assertEquals(expectedMovie.getRating(), actualMovie.getRating(), 0.1);
        assertEquals(expectedMovie.getPrice(), actualMovie.getPrice(), 0.1);
        assertEquals(expectedMovie.getPicturePath(), actualMovie.getPicturePath());
    }

  @Test
    public void testGetThreeRandomMovies() {

        List<Movie> actualMovieList = movieDao.getThreeRandomMovies();
        assertEquals(3, actualMovieList.size());

    }
}


