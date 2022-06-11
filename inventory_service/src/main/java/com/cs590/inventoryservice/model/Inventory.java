package com.cs590.inventoryservice.model;

import com.mongodb.client.model.Collation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Inventories")
public class Inventory {

@Id
private String id;
private Long carId;
@DateTimeFormat(pattern = "yyyy-mm-dd")
private LocalDate startDate;
@DateTimeFormat(pattern = "yyyy-mm-dd")
private LocalDate endDate;
}
