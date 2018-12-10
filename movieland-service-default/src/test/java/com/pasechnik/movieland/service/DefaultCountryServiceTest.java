package com.pasechnik.movieland.service;

import com.pasechnik.movieland.dao.CountryDao;
import com.pasechnik.movieland.entity.Country;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultCountryServiceTest {

    @Test
    public void testGetMovieById() {

        CountryDao countryDao = mock(CountryDao.class);

        List<Country> expectedCountryList = new ArrayList<>();

        Country country = new Country(1, "драма");
        expectedCountryList.add(country);

        DefaultCountryService countryService = new DefaultCountryService(countryDao);

        when(countryDao.getByMovieId(2)).thenReturn(expectedCountryList);

        List<Country> actualCountryList = countryService.getByMovieId(2);

        assertEquals(1, actualCountryList.size());

        for (Country actualCountry : actualCountryList) {
            assertTrue(expectedCountryList.contains(actualCountry));
        }
    }
}
