package com.c1120g1.cinema.dto;

public class PaypalDTO {

    private double price;

    public PaypalDTO(double price) {
        this.price = price;
    }

    public PaypalDTO() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
