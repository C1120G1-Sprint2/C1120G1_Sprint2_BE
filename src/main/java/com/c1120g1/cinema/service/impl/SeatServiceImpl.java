package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.SeatRepository;

import com.c1120g1.cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRepository seatRepository;

}
