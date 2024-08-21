package com.anantmathur.tablebookingapp;

import com.anantmathur.tablebookingapp.Controller.RatingReviewController;
import com.anantmathur.tablebookingapp.model.RatingReview;
import com.anantmathur.tablebookingapp.service.RatingReviewService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RatingReviewControllerTest {

    @Mock
    private RatingReviewService ratingReviewService;

    @InjectMocks
    private RatingReviewController ratingReviewController;

    public RatingReviewControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateRatingReview() {
        RatingReview ratingReview = new RatingReview();

        when(ratingReviewService.addRatingReview(any(RatingReview.class))).thenReturn(ratingReview);

        ResponseEntity<RatingReview> response = ratingReviewController.createRatingReview(ratingReview);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(ratingReviewService, times(1)).addRatingReview(ratingReview);
    }
}
