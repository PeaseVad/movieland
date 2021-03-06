package com.pasechnik.movieland.dao.mapper;

import com.pasechnik.movieland.entity.Country;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryRowMapperTest {

    @Test
    public void testMapRow() throws SQLException {
        CountryRowMapper countryRowMapper = new CountryRowMapper();
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name")).thenReturn("США");

        Country actualCountry = countryRowMapper.mapRow(resultSet, 0);

        assertEquals(1, actualCountry.getId());
        assertEquals("США", actualCountry.getName());
    }
}


