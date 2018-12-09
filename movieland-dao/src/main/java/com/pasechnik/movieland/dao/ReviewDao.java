package com.pasechnik.movieland.dao;

import com.pasechnik.movieland.entity.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> getByMovieId(int id);
}
