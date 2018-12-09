package com.pasechnik.movieland.dao.mapper;

import com.pasechnik.movieland.entity.MovieWithDescription;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieWithDescriptionRowMapperTest {

    @Test
    public void testMapRow() throws SQLException {
        MovieWithDescriptionRowMapper movieWithDescriptionRowMapper = new MovieWithDescriptionRowMapper();
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("movie_name_rus")).thenReturn("Список Шиндлера");
        when(resultSet.getString("movie_name_native")).thenReturn("Schindler's List");
        when(resultSet.getString("release_date")).thenReturn("1993");
        when(resultSet.getString("storyline")).thenReturn("Сымитировав помешательство в надежде избежать тюремного заключения, Рэндл Патрик МакМерфи попадает в психиатрическую клинику, где почти безраздельным хозяином является жестокосердная сестра Милдред Рэтчед. МакМерфи поражается тому, что прочие пациенты смирились с существующим положением вещей, а некоторые — даже сознательно пришли в лечебницу, прячась от пугающего внешнего мира. И решается на бунт. В одиночку.");
        when(resultSet.getDouble("rating")).thenReturn(8.7);
        when(resultSet.getDouble("price")).thenReturn(150.5);
        when(resultSet.getString("poster")).thenReturn("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");

        MovieWithDescription actualMovie = movieWithDescriptionRowMapper.mapRow(resultSet, 0);

        assertEquals(1, actualMovie.getId());
        assertEquals("Список Шиндлера", actualMovie.getNameRussian());
        assertEquals("Schindler's List", actualMovie.getNameNative());
        assertEquals("1993", actualMovie.getYearOfRelease());
        assertEquals("Сымитировав помешательство в надежде избежать тюремного заключения, Рэндл Патрик МакМерфи попадает в психиатрическую клинику, где почти безраздельным хозяином является жестокосердная сестра Милдред Рэтчед. МакМерфи поражается тому, что прочие пациенты смирились с существующим положением вещей, а некоторые — даже сознательно пришли в лечебницу, прячась от пугающего внешнего мира. И решается на бунт. В одиночку.", actualMovie.getDescription());
        assertEquals(8.7, actualMovie.getRating(), 0.1);
        assertEquals(150.5, actualMovie.getPrice(), 0.1);
        assertEquals("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg", actualMovie.getPicturePath());
    }
}