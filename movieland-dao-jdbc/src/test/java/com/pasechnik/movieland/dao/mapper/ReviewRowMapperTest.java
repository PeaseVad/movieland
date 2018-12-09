package com.pasechnik.movieland.dao.mapper;

import com.pasechnik.movieland.entity.Review;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReviewRowMapperTest {

    @Test
    public void testMapRow() throws SQLException {
        ReviewRowMapper reviewRowMapper = new ReviewRowMapper();
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(32);
        when(resultSet.getString("review_text")).thenReturn("Скажу только одно — как я жалею, что не посмотрела его раньше!");
        when(resultSet.getInt("user_id")).thenReturn(10);
        when(resultSet.getString("user_email")).thenReturn("dennis.craig82@example.com");
        Review actualReview = reviewRowMapper.mapRow(resultSet, 0);

        assertEquals(32, actualReview.getId());
        assertEquals("Скажу только одно — как я жалею, что не посмотрела его раньше!", actualReview.getText());
        assertEquals(10, actualReview.getUser().getId());
        assertEquals("dennis.craig82@example.com", actualReview.getUser().getNickname());
    }
}


