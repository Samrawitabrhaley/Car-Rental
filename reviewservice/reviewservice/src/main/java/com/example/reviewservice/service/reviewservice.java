package com.example.reviewservice.service;

import com.example.reviewservice.domain.Review;

import java.util.List;

public interface reviewservice  {
    List<Review> findAll();

    Review findById(String id);

    Review findByCarId(String carid);

    List<Review> findAllByOrderByRate();

    Review saveOrUpdateReview(Review review);

    void deleteReviewById(String id);

}
