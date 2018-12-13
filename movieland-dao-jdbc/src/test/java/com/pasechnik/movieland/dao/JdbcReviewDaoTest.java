
package com.pasechnik.movieland.dao;

import com.pasechnik.movieland.entity.Review;
import com.pasechnik.movieland.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = {TestDaoConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class JdbcReviewDaoTest {

    @Autowired
    private ReviewDao reviewDao;

    @Test
    public void testgetByMovieId() {

        Review expectedReview = new Review();
        expectedReview.setId(32);
        User user = new User(10, "dennis.craig82@example.com");
        expectedReview.setUser(user);
        expectedReview.setText("Скажу только одно — как я жалею, что не посмотрела его раньше!");

        List<Review> actualReviewList = reviewDao.getByMovieId(2);
        assertEquals(1, actualReviewList.size());

        int index = actualReviewList.indexOf(expectedReview);
        Review actualReview = actualReviewList.get(index);

        assertEquals(expectedReview.getId(), actualReview.getId());
        assertEquals(expectedReview.getUser(), actualReview.getUser());
        assertEquals(expectedReview.getText(), actualReview.getText());
    }
}


