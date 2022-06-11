package com.cs590.inventoryservice.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestBody {
    private Long carID;
    private Long renterId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalPrice;
    private Boolean isPaid;
}
