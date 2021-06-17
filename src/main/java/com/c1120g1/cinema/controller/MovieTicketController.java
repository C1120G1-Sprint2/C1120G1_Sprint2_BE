package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.MovieTicket;
import com.c1120g1.cinema.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieTicketController {
    @Autowired
    private MovieTicketService movieTicketService;

    /**
     * Method: get all movie ticket
     * Author: HanTH
     *
     * @return
     */
    @GetMapping("api/employee/saleTicket/listMovieTicket")
    public ResponseEntity<?> showAllMovieTicket() {

        try {
            List<MovieTicket> ticketList = movieTicketService.showAllMovieTicket();
            if (ticketList.isEmpty()) {
                return new ResponseEntity<>( HttpStatus.NO_CONTENT );
            } else {
                return new ResponseEntity<>( ticketList, HttpStatus.OK );
            }
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }

    }

    @GetMapping("api/employee/saleTicket/listMovieTicket/{movieId}")
    public ResponseEntity<?> showAllMovieTicket(@PathVariable Integer movieId) {

        try {
            List<MovieTicket> ticketList = movieTicketService.showAllMovieTicketById( movieId );
            if (ticketList.isEmpty()) {
                return new ResponseEntity<>( HttpStatus.NO_CONTENT );
            } else {
                return new ResponseEntity<>( ticketList, HttpStatus.OK );
            }
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }

    }

    @GetMapping("api/employee/saleTicket/listMovieTicket/{movieId}/{showDate}")
    public ResponseEntity<?> showAllMovieTicket(@PathVariable Integer movieId, @PathVariable String showDate) {

        try {
            List<MovieTicket> ticketList = movieTicketService.showAllMovieTicketByIdAndShowDate( movieId, showDate );
            if (ticketList.isEmpty()) {
                return new ResponseEntity<>( HttpStatus.NO_CONTENT );
            } else {
                return new ResponseEntity<>( ticketList, HttpStatus.OK );
            }
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }

    }
}
