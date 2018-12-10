package com.pasechnik.movieland.dao;

import com.pasechnik.movieland.dao.mapper.ReviewRowMapper;
import com.pasechnik.movieland.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcReviewDao implements ReviewDao {
    private static final ReviewRowMapper REVIEW_ROW_MAPPER = new ReviewRowMapper();
    private JdbcTemplate jdbcTemplate;
    private String getReviewByMovieIdSQL;

    @Override
    public List<Review> getByMovieId(int id) {
        return jdbcTemplate.query(getReviewByMovieIdSQL, REVIEW_ROW_MAPPER, id);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setGetReviewByMovieIdSQL(String getReviewByMovieIdSQL) {
        this.getReviewByMovieIdSQL = getReviewByMovieIdSQL;
    }
}
