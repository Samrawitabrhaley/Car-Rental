package com.cs590.car.service;

import com.cs590.car.domain.Car;

import java.util.List;

public interface CarService {

    public Car addCar(Car car);

    public List<Car> getAllCars();

    public Car getCarById(String id);

    public void deleteById(String id);

    public Car updateById(String id, Car car);

    public List<Car> carsNotBooked(List<String> ids);

    public Double isCarActive(String id);
}
