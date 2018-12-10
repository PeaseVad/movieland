package com.pasechnik.movieland.service;

import com.pasechnik.movieland.dao.ReviewDao;
import com.pasechnik.movieland.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultReviewService implements ReviewService {

    private ReviewDao reviewDao;

    @Autowired
    public DefaultReviewService(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public List<Review> getByMovieId(int id) {
        return reviewDao.getByMovieId(id);
    }
}
