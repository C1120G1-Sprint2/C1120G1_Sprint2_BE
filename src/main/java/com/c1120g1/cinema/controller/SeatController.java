package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SeatController {
    @Autowired
    private SeatService seatService;
}
