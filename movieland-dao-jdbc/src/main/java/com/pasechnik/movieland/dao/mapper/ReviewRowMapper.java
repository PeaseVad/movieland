package com.pasechnik.movieland.dao.mapper;

import com.pasechnik.movieland.entity.Review;
import com.pasechnik.movieland.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {
    @Override
    public Review mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String text = resultSet.getString("review_text");
        int userId = resultSet.getInt("user_id");
        String userEmail = resultSet.getString("user_email");
        User user = new User(userId, userEmail);
        Review review = new Review(id, user, text);
        return review;
    }
}