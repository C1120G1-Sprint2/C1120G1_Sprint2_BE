package com.c1120g1.cinema.dto;

import java.time.LocalDate;

public interface MovieStatisticalDTO {

    LocalDate getCreateDate();
    int getRevenue();
    int getTicketQuantity();
}
