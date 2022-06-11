package com.example.reviewservice.repository;
import com.example.reviewservice.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface reviewrepository  extends MongoRepository<Review, String> {

    Review findByCarId(String carid);

    List<Review> findAllByOrderByRate();

}
