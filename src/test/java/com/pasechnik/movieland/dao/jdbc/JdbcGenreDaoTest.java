
package com.pasechnik.movieland.dao.jdbc;

import com.pasechnik.movieland.dao.GenreDao;
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
@ContextConfiguration(locations = {"file:src/main/resources/spring/root-context.xml", "file:src/main/webapp/WEB-INF/movieland-servlet.xml", "classpath:/spring/test-context.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class JdbcGenreDaoTest {
    @Autowired
    private GenreDao genreDao;

    @Test
    public void testGetAll() {

        Genre expectedGenre = new Genre();
        expectedGenre.setId(1);
        expectedGenre.setName("драма");

        List<Genre> actualGenreList = genreDao.getAll();
        assertEquals(15, actualGenreList.size());

        int index = actualGenreList.indexOf(expectedGenre);
        Genre actualGenre = actualGenreList.get(index);

        assertEquals(expectedGenre.getId(), actualGenre.getId());
        assertEquals(expectedGenre.getName(), actualGenre.getName());
    }
}


