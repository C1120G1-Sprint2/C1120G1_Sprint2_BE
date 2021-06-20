package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.MovieTicket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieTicketController {

    @PostMapping("/api/movie-ticket/create")
    public ResponseEntity<Void> create(@RequestBody MovieTicket movieTicket) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
