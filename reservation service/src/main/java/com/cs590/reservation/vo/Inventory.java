package com.cs590.reservation.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    private String carId;
    private LocalDate startDate;
    private LocalDate endDate;
}
