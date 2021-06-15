package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private MovieTicketService movieTicketService;

    @Autowired
    private TicketStatusService ticketStatusService;

    @Autowired
    private ShowTimeService showTimeService;
}
