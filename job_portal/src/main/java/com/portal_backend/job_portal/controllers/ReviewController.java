package com.portal_backend.job_portal.controllers;

import com.portal_backend.job_portal.entities.Review;
import com.portal_backend.job_portal.services.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.addReview(review));
    }

    @GetMapping
    public ResponseEntity<List<Review>> getReviews() {
        return ResponseEntity.ok(reviewService.getReviews());
    }
}

