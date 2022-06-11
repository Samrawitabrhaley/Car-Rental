package com.cs590.inventoryservice.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseBody {
    private List<String> carIds;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isAvailable;
}
