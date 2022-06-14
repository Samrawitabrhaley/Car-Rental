package com.cs590.car.service;

import com.cs590.car.domain.Car;
import com.cs590.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(String id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car updateById(String id, Car car) {
        var carFromDatabase=carRepository.findById(id).orElse(null);
        carFromDatabase.setName(car.getName());
        carFromDatabase.setDetails(car.getDetails());
        carFromDatabase.setPricePerDay(car.getPricePerDay());
        carFromDatabase.setActive(car.isActive());
        carFromDatabase.setCategory(car.getCategory());
        return carRepository.save(carFromDatabase);
    }

    @Override
    public List<Car> carsNotBooked(List<String> ids) {
        return carRepository.findAllByIdIsNotIn(ids);
    }

    @Override
    public Double isCarActive(String id) {
        Car car = carRepository.findById(id).get();
        if(car.isActive()){
            return car.getPricePerDay();
        }
        else {
            return null;
        }
    }
}
