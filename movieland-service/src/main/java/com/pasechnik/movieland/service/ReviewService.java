package com.pasechnik.movieland.service;

import com.pasechnik.movieland.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getByMovieId(int id);
}
