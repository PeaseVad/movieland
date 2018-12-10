
package com.pasechnik.movieland.dao;

import com.pasechnik.movieland.common.RequestAdditionalParam;
import com.pasechnik.movieland.common.SortField;
import com.pasechnik.movieland.common.SortType;
import com.pasechnik.movieland.entity.Movie;
import com.pasechnik.movieland.entity.MovieWithDescription;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring/movieland-dao-jdbc-context.xml", "classpath:/spring/test-context.xml"})
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

    @Test
    public void testGetMoviesByGenreWithSort() {

        Movie expectedMovie1 = new Movie();
        expectedMovie1.setId(3);
        expectedMovie1.setNameRussian("Форрест Гамп");
        expectedMovie1.setNameNative("Forrest Gump");
        expectedMovie1.setYearOfRelease("1994");
        expectedMovie1.setRating(8.6);
        expectedMovie1.setPrice(200.6);
        expectedMovie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR2,0,140,209_.jpg");

        RequestAdditionalParam requestAdditionalParam = new RequestAdditionalParam();
        requestAdditionalParam.setSortField(SortField.PRICE);
        requestAdditionalParam.setSortType(SortType.DESC);

        List<Movie> actualMovieList1 = movieDao.getMoviesByGenre(5, requestAdditionalParam);
        Movie actualMovie1 = actualMovieList1.get(0);

        assertEquals(expectedMovie1, actualMovie1);

        requestAdditionalParam.setSortType(SortType.ASC);

        Movie expectedMovie2 = new Movie();

        expectedMovie2.setId(10);
        expectedMovie2.setNameRussian("Жизнь прекрасна");
        expectedMovie2.setNameNative("La vita è bella");
        expectedMovie2.setYearOfRelease("1997");
        expectedMovie2.setRating(8.2);
        expectedMovie2.setPrice(145.99);
        expectedMovie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg");

        List<Movie> actualMovieList2 = movieDao.getMoviesByGenre(5, requestAdditionalParam);
        Movie actualMovie2 = actualMovieList2.get(0);

        assertEquals(expectedMovie2, actualMovie2);
    }

    @Test
    public void testGetMoviesWithSort() {

        Movie expectedMovie1 = new Movie();
        expectedMovie1.setId(17);
        expectedMovie1.setNameRussian("Зеленая миля");
        expectedMovie1.setNameNative("The Green Mile");
        expectedMovie1.setYearOfRelease("1999");
        expectedMovie1.setRating(8.9);
        expectedMovie1.setPrice(134.67);
        expectedMovie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg");

        RequestAdditionalParam requestAdditionalParam = new RequestAdditionalParam();
        requestAdditionalParam.setSortField(SortField.RATING);
        requestAdditionalParam.setSortType(SortType.DESC);

        List<Movie> actualMovieList1 = movieDao.getAll(requestAdditionalParam);
        Movie actualMovie1 = actualMovieList1.get(0);

        assertEquals(expectedMovie1, actualMovie1);

        requestAdditionalParam.setSortType(SortType.ASC);

        Movie expectedMovie2 = new Movie();
        expectedMovie2.setId(7);
        expectedMovie2.setNameRussian("Блеф");
        expectedMovie2.setNameNative("Bluff storia di truffe e di imbroglioni");
        expectedMovie2.setYearOfRelease("1976");
        expectedMovie2.setRating(7.6);
        expectedMovie2.setPrice(100);
        expectedMovie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg");

        List<Movie> actualMovieList2 = movieDao.getAll(requestAdditionalParam);
        Movie actualMovie2 = actualMovieList2.get(0);

        assertEquals(expectedMovie2, actualMovie2);
    }

    @Test
    public void getMovieById() {

        MovieWithDescription expectedMovie = new MovieWithDescription();
        expectedMovie.setId(2);
        expectedMovie.setNameRussian("Пролетая над гнездом кукушки");
        expectedMovie.setNameNative("One Flew Over the Cuckoo's Nest");
        expectedMovie.setYearOfRelease("1975");
        expectedMovie.setDescription("Сымитировав помешательство в надежде избежать тюремного заключения, Рэндл Патрик МакМерфи попадает в психиатрическую клинику, где почти безраздельным хозяином является жестокосердная сестра Милдред Рэтчед. МакМерфи поражается тому, что прочие пациенты смирились с существующим положением вещей, а некоторые — даже сознательно пришли в лечебницу, прячась от пугающего внешнего мира. И решается на бунт. В одиночку.");
        expectedMovie.setRating(8.7);
        expectedMovie.setPrice(180.0);
        expectedMovie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BZjA0OWVhOTAtYWQxNi00YzNhLWI4ZjYtNjFjZTEyYjJlNDVlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg");

        MovieWithDescription actualMovie = movieDao.getMovieById(2);

        assertEquals(expectedMovie.getId(), actualMovie.getId());
        assertEquals(expectedMovie.getNameRussian(), actualMovie.getNameRussian());
        assertEquals(expectedMovie.getNameNative(), actualMovie.getNameNative());
        assertEquals(expectedMovie.getYearOfRelease(), actualMovie.getYearOfRelease());
        assertEquals(expectedMovie.getDescription(), actualMovie.getDescription());
        assertEquals(expectedMovie.getRating(), actualMovie.getRating(), 0.1);
        assertEquals(expectedMovie.getPrice(), actualMovie.getPrice(), 0.1);
        assertEquals(expectedMovie.getPicturePath(), actualMovie.getPicturePath());
    }
}


