package com.example.reviewservice.service;

import com.example.reviewservice.domain.Review;
import com.example.reviewservice.repository.reviewrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Reviewserviceimpl implements reviewservice{
    @Autowired
    private reviewrepository reviewrepository;
    @Override
    public List<Review> findAll() {
        return  reviewrepository.findAll();
    }

    @Override
    public Review findById(String id) {
        return reviewrepository.findById(id).get();
    }

    @Override
    public Review findByCarId(String carid) {
        return reviewrepository.findByCarId(carid);
    }

    @Override
    public List<Review> findAllByOrderByRate() {
        return reviewrepository.findAllByOrderByRate();
    }

    @Override
    public Review saveOrUpdateReview(Review review) {
        return reviewrepository.save(review);
    }

    @Override
    public void deleteReviewById(String id) {
        reviewrepository.deleteById(id);
    }



}
