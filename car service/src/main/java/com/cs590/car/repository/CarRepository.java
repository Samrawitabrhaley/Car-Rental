package com.cs590.car.repository;

import com.cs590.car.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    public List<Car> findAllByIdIsNotIn(List<String> ids);

}
