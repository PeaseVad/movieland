
package com.pasechnik.movieland.dao.jdbc;

import com.pasechnik.movieland.dao.MovieDao;
import com.pasechnik.movieland.entity.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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

    @Test
    public void testGetMoviesByGenre() {

        List<Movie> expectedMovieList = new ArrayList<>();

        Movie expectedMovie1 = new Movie();
        expectedMovie1.setId(22);
        expectedMovie1.setNameRussian("Титаник");
        expectedMovie1.setNameNative("Titanic");
        expectedMovie1.setYearOfRelease("1997");
        expectedMovie1.setRating(7.9);
        expectedMovie1.setPrice(150);
        expectedMovie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovieList.add(expectedMovie1);

        Movie expectedMovie2 = new Movie();
        expectedMovie2.setId(3);
        expectedMovie2.setNameRussian("Форрест Гамп");
        expectedMovie2.setNameNative("Forrest Gump");
        expectedMovie2.setYearOfRelease("1994");
        expectedMovie2.setRating(8.6);
        expectedMovie2.setPrice(200.6);
        expectedMovie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR2,0,140,209_.jpg");
        expectedMovieList.add(expectedMovie2);

        Movie expectedMovie3 = new Movie();
        expectedMovie3.setId(10);
        expectedMovie3.setNameRussian("Жизнь прекрасна");
        expectedMovie3.setNameNative("La vita è bella");
        expectedMovie3.setYearOfRelease("1997");
        expectedMovie3.setRating(8.2);
        expectedMovie3.setPrice(145.99);
        expectedMovie3.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovieList.add(expectedMovie3);

        List<Movie> actualMovieList = movieDao.getMoviesByGenre(5);

        assertEquals(3, actualMovieList.size());

        for (Movie actualMovie : actualMovieList) {
            assertTrue(expectedMovieList.contains(actualMovie));
        }
    }
}


