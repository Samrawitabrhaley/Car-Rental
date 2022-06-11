package com.cs590.car.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "cars")
public class Car {

    @Id
    private String id;
    private String name;
    private String details;
    private double pricePerDay;
    private boolean isActive;
    private Category category;
}
