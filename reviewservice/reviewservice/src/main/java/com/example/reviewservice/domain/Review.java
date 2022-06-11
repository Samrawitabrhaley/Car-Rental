package com.example.reviewservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reviews")
public class Review {
    @Id
    private String id;
    private String userId;
    private String carId;
    private int rate;
    private String comment;


}
