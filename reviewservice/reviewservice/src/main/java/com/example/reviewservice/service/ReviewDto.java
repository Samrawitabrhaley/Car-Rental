package com.example.reviewservice.service;

public class ReviewDto {
    private String id;
    private String carId;
    private int rate;
    private String comment;

    public ReviewDto(String id){
        this.id=id;
    }
    public ReviewDto(){}

    public void setReviewid(String id) { this.id=id;}
    public String getCarId() {
        return carId;
    }
    public void setCarid(String carid) {
        this.carId=id;
    }
    public int getRate() {
        return rate;
    }
    public void setRate(int rate) {
        this.rate=rate;
    }
    public String getComment() {
        return comment;
    }
    public void seComment(String comment) {
        this.comment=comment;
    }



}

