package com.example.reviewservice.controller;

import com.example.reviewservice.Utils.JwtUtils;
import com.example.reviewservice.Utils.ObjectMapperUtils;
import com.example.reviewservice.domain.Review;
import com.example.reviewservice.service.ReviewDto;
import com.example.reviewservice.service.Reviewserviceimpl;
import com.example.reviewservice.service.reviewservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reviews")
public class reviewcontroller {

    @Autowired
    private reviewservice reviewservice;

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private Environment environment;

    @GetMapping(value = "/")
    public List<ReviewDto> getAllReviews() {
        return ObjectMapperUtils.mapAll(reviewservice.findAll(), ReviewDto.class);
    }

    @GetMapping(value = "/byId/{id}")
    public ReviewDto getReviewById(@PathVariable("id") String id) {
        return ObjectMapperUtils.map(reviewservice.findById(id), ReviewDto.class);
    }

    @GetMapping(value = "/byCarid/{carid}")
    public ReviewDto getReviewBycarId(@PathVariable("carid") String carid) {
        return ObjectMapperUtils.map(reviewservice.findByCarId(carid), ReviewDto.class);
    }

    @GetMapping(value = "/orderByRate")
    public List<ReviewDto> findAllByOrderByRate() {
        return ObjectMapperUtils.mapAll(reviewservice.findAllByOrderByRate(), ReviewDto.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateReview(@RequestBody ReviewDto ReviewDto) {
        reviewservice.saveOrUpdateReview(ObjectMapperUtils.map(ReviewDto, Review.class));
        return new ResponseEntity("Review added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable String id) {
        reviewservice.deleteReviewById(reviewservice.findById(id).getId());
        return new ResponseEntity("Review deleted successfully", HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Review> saveReview(Review review,@RequestHeader(value = "Authorization", required = false) String headerAuth){

        String token = parseJwt(headerAuth);
        if(token != null && jwtUtils.validateJwtToken(token)){
            String userId = jwtUtils.getUserIdFromJwtToken(token);
            review.setUserId(userId);
            return ResponseEntity.status(HttpStatus.OK).body(reviewservice.saveOrUpdateReview(review));
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    private String parseJwt(String headerAuth) {
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }





}
