
package com.pasechnik.movieland.dao;

import com.pasechnik.movieland.entity.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring/movieland-dao-jdbc-context.xml", "classpath:/spring/test-context.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class JdbcCountryDaoTest {

    @Autowired
    private CountryDao countryDao;

    @Test
    public void testgetByMovieId() {

        Country expectedCountry = new Country(1, "США");

        List<Country> actualCountryList = countryDao.getByMovieId(2);
        assertEquals(1, actualCountryList.size());

        int index = actualCountryList.indexOf(expectedCountry);
        Country actualCountry = actualCountryList.get(index);

        assertEquals(expectedCountry.getId(), actualCountry.getId());
        assertEquals(expectedCountry.getName(), actualCountry.getName());
    }
}


