package com.cs590.inventoryservice.repository;

import com.cs590.inventoryservice.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory,String> {
    @Query(value = "{$or:[{'inventory.startDate':  {$lte : ?0}, 'inventory.endDate': {$gte : ?0}},{'inventory.startDate':  {$lte : ?0}, 'inventory.endDate': {$gte : ?0}}]}", fields = "{'inventory' : 0}")
    public List<String> bookedCarsId(LocalDate startDate, LocalDate endDate);
}
