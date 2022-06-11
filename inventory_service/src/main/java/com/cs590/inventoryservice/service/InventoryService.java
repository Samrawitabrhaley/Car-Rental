package com.cs590.inventoryservice.service;

import com.cs590.inventoryservice.model.Inventory;
import com.cs590.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventory(){
        return inventoryRepository.findAll();
    }
    public Inventory addInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    public Optional<Inventory> getInventoryById(String id){
        return inventoryRepository.findById(id);
    }
    public List<String> listOfBookedCars(LocalDate startDate,LocalDate endDate){


        List<String> carIds = inventoryRepository.bookedCarsId(startDate,endDate);
        System.out.println(carIds);
        return carIds;
    }
}
