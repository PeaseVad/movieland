package com.pasechnik.movieland.service;

import com.pasechnik.movieland.dao.GenreDao;
import com.pasechnik.movieland.dao.MovieDao;
import com.pasechnik.movieland.entity.Genre;
import com.pasechnik.movieland.entity.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultGenreServiceTest {

    @Test
    public void testGetAll() {
        GenreDao genreDao = mock(GenreDao.class);

        List<Genre> expectedGenreList = new ArrayList<>();

        Genre genre1 = new Genre();
        genre1.setId(1);
        genre1.setName("драма");
        expectedGenreList.add(genre1);

        Genre genre2 = new Genre();
        genre2.setId(2);
        genre2.setName("криминал");
        expectedGenreList.add(genre2);

        DefaultGenreService genreService = new DefaultGenreService(genreDao);

        when(genreDao.getAll()).thenReturn(expectedGenreList);

        List<Genre> actualGenreList = genreService.getAll();

        assertEquals(2, actualGenreList.size());

        for (Genre actualGenre : actualGenreList) {
            assertTrue(expectedGenreList.contains(actualGenre));
        }
    }
}
