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
    public ResponseEntity<List<MovieTicket>> showAllMovieTicket() {

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

    /**
     * Method: get all movie ticket by movie id
     * Author: HanTH
     *
     * @param movieId
     * @return
     */
    @GetMapping("api/employee/saleTicket/listMovieTicket/movie/{movieId}")
    public ResponseEntity<List<MovieTicket>> showAllMovieTicket(@PathVariable Integer movieId) {

        try {
            List<MovieTicket> ticketList = movieTicketService.showAllMovieTicketByMovieId( movieId );
            if (ticketList.isEmpty()) {
                return new ResponseEntity<>( HttpStatus.NO_CONTENT );
            } else {
                return new ResponseEntity<>( ticketList, HttpStatus.OK );
            }
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }

    }

    /**
     * Method: get all movie ticket by movie id
     * Author: HanTH
     *
     * @param showDate
     * @return
     */
    @GetMapping("api/employee/saleTicket/listMovieTicket/showDate/{showDate}")
    public ResponseEntity<List<MovieTicket>> showAllMovieTicket(@PathVariable String showDate) {

        try {
            List<MovieTicket> ticketList = movieTicketService.showAllMovieTicketByShowDate( showDate );
            if (ticketList.isEmpty()) {
                return new ResponseEntity<>( HttpStatus.NO_CONTENT );
            } else {
                return new ResponseEntity<>( ticketList, HttpStatus.OK );
            }
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }

    }

    /**
     * Method: get all movie ticket by movie id and show date
     * Author: HanTH
     *
     * @param movieId
     * @param showDate
     * @return
     */
    @GetMapping("api/employee/saleTicket/listMovieTicket/{movieId}/{showDate}")
    public ResponseEntity<List<MovieTicket>> showAllMovieTicket(@PathVariable Integer movieId, @PathVariable String showDate) {

        try {
            List<MovieTicket> ticketList = movieTicketService.showAllMovieTicketByMovieIdAndShowDate( movieId, showDate );
            if (ticketList.isEmpty()) {
                return new ResponseEntity<>( HttpStatus.NO_CONTENT );
            } else {
                return new ResponseEntity<>( ticketList, HttpStatus.OK );
            }
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }

    }

    /**
     * Method: get movie ticket by id
     * Author: HanTH
     *
     * @param movieTicketId
     * @return
     */
    @GetMapping("api/employee/saleTicket/movieTicket/{movieTicketId}")
    public ResponseEntity<MovieTicket> findMovieTicketById(@PathVariable Integer movieTicketId) {
        try {
            MovieTicket movieTicket = movieTicketService.findMovieTicketById( movieTicketId );
            return new ResponseEntity<>( movieTicket, HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

    /**
     * Method: get movie ticket by select
     * Author: HanTH
     * @param movieId
     * @param showDate
     * @param showTimeId
     * @return
     */
    @GetMapping("api/employee/saleTicket/movieTicket/{movieId}/{showDate}/{showTimeId}")
    public ResponseEntity<MovieTicket> findMovieTicketById(@PathVariable Integer movieId, @PathVariable String showDate, @PathVariable Integer showTimeId) {
        try {
            MovieTicket movieTicket = movieTicketService.findMovieTicketBySelect( movieId, showDate, showTimeId );
            return new ResponseEntity<>( movieTicket, HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
}
