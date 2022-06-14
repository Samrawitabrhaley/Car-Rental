package com.cs590.inventoryservice.controller;

import com.cs590.inventoryservice.dto.ReservationDto;
import com.cs590.inventoryservice.model.Inventory;
import com.cs590.inventoryservice.service.InventoryService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventories")
    public List<Inventory> getAllInventory(){
        return inventoryService.getAllInventory();
    }

    @GetMapping("/{id}")
    public Inventory getInvetoryById(@PathVariable String id){
        return null;
    }

    @PostMapping
   // @JsonDeserialize(using = LocalDateDeserializer.class)
    public Inventory addInvnetory(@RequestBody Inventory inventory){

        return inventoryService.addInventory(inventory);
    }

    @DeleteMapping("/remove/{id}")
    public String removeInventory(@PathVariable String id){
        return "removed successfully";
    }
//
//    @PutMapping("/update/{id}")
//    public Inventory updateInventory(@PathVariable Long id, @RequestBody Inventory inventory){
//        return null;
//    }

    @GetMapping("/isAvailable")
    public Boolean isInventoryAvailable(){
         return false;
    }

    @PostMapping("/cars")
    public List<String> getBookedCars(@RequestBody ReservationDto reservationDto){
        LocalDate startDate = reservationDto.getStartDate();
        LocalDate endDate = reservationDto.getEndDate();
        return inventoryService.listOfBookedCars(startDate,endDate);
    }
}
