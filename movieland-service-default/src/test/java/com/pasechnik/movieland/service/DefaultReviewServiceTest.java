package com.pasechnik.movieland.service;

import com.pasechnik.movieland.dao.ReviewDao;
import com.pasechnik.movieland.entity.Review;
import com.pasechnik.movieland.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultReviewServiceTest {

    @Test
    public void testGetByMovieId() {
        ReviewDao reviewDao = mock(ReviewDao.class);

        List<Review> expectedReviewList = new ArrayList<>();
        User user = new User(10, "dennis.craig82@example.com");
        Review review = new Review(32, user, "Скажу только одно — как я жалею, что не посмотрела его раньше!");
        expectedReviewList.add(review);

        DefaultReviewService reviewService = new DefaultReviewService(reviewDao);

        when(reviewDao.getByMovieId(2)).thenReturn(expectedReviewList);

        List<Review> actualReviewList = reviewService.getByMovieId(2);

        assertEquals(1, actualReviewList.size());

        for (Review actualReview : actualReviewList) {
            assertTrue(expectedReviewList.contains(actualReview));
        }
    }
}