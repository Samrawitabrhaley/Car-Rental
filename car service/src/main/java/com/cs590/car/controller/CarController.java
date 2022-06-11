package com.cs590.car.controller;

import com.cs590.car.domain.Car;
import com.cs590.car.domain.Category;
import com.cs590.car.service.CarService;
import com.cs590.car.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;
    private final CategoryService categoryService;

    public CarController(CarService carService, CategoryService service) {
        this.carService = carService;
        this.categoryService = service;
    }

    @PostMapping("")
    public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(String id){
       return carService.getCarById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        carService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Car updateById(@PathVariable String id, @RequestBody Car car){
        return carService.updateById(id, car);
    }

    @PostMapping("/available")
    public List<Car> carsAvailableForRent(@RequestBody List<String> ids){
        return carService.carsNotBooked(ids);
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @GetMapping("/{id}/active")
    public ResponseEntity<Double> isCarActive(@PathVariable("id")String id){
        Double pricePerDay =carService.isCarActive(id);
        if (pricePerDay != null){
            return ResponseEntity.status(HttpStatus.OK).body(pricePerDay);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
