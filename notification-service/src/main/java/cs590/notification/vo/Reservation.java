package cs590.notification.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    private String id;
    private String fullName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String carId;
    private String renterId;
    private Double totalPrice;
    private Payment payment;
}
