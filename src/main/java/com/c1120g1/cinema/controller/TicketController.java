package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.entity.Ticket;
import com.c1120g1.cinema.entity.TicketStatus;
import com.c1120g1.cinema.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieTicketService movieTicketService;

    @Autowired
    private TicketStatusService ticketStatusService;

    @Autowired
    private ShowTimeService showTimeService;

    @GetMapping("/api/booking/listMovie")
    public ResponseEntity<List<Movie>> getListMovie(){
        List<Movie> listMovie = movieService.findAll();
        if (listMovie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listMovie, HttpStatus.OK);
    }
}
