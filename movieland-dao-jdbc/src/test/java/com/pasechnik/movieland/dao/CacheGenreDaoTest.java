package com.pasechnik.movieland.dao;

import com.pasechnik.movieland.entity.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = {TestDaoConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class CacheGenreDaoTest {

    @Autowired
    GenreDao cachedGenreDao;

    @Test
    public void testGetAll() {

        Genre expectedGenre = new Genre(1, "драма");

        List<Genre> actualGenreList = cachedGenreDao.getAll();
        assertEquals(15, actualGenreList.size());

        int index = actualGenreList.indexOf(expectedGenre);
        Genre actualGenre = actualGenreList.get(index);

        assertEquals(expectedGenre.getId(), actualGenre.getId());
        assertEquals(expectedGenre.getName(), actualGenre.getName());
    }
}


