package com.c1120g1.cinema.dto;

import java.time.LocalDate;

public interface MovieStatisticalDTO {

    LocalDate getCreateDate();
    String getMovieName();
    int getRevenue();
    int getTicketQuantity();
}
