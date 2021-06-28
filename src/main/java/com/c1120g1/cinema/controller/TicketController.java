package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Ticket;
import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.entity.MovieTicket;
import com.c1120g1.cinema.entity.ShowTime;

import com.c1120g1.cinema.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/ticket")
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

    @GetMapping(value = "/booking", params = {"page", "username"})
    public ResponseEntity<Page<Ticket>> getListTickets(
            @RequestParam("username") String username, Pageable pageable) {
        Page<Ticket> tickets = ticketService.findAllTicketByUsername(pageable, username);
        if (tickets == null) {
            return new ResponseEntity<Page<Ticket>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Ticket>>(tickets, HttpStatus.OK);
    }

    @DeleteMapping("/cancelTicket/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Ticket currentTicket = ticketService.findById(id);
        if (currentTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ticketService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listMovie")
    public ResponseEntity<List<Movie>> getListMovie() {
        List<Movie> listMovie = movieService.findAll();
        if (listMovie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Integer id = null;
        ticketService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listShowTime/{date}")
    public ResponseEntity<List<ShowTime>> getListShowTime(@PathVariable(name = "date") String date) {
        List<ShowTime> listShowTime = showTimeService.getAllShowTimeByDate(date);
        if (listShowTime.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listShowTime, HttpStatus.OK);
    }

    @GetMapping("/movieTicket/{movieId}/{date}/{showTimeId}")
    public ResponseEntity<MovieTicket> getMovieTicket(@PathVariable(name = "movieId") Integer movieId,
                                                      @PathVariable(name = "date") String date,
                                                      @PathVariable(name = "showTimeId") Integer showTimeId) {
        MovieTicket movieTicket = this.movieTicketService.getMovieTicket(movieId, date, showTimeId);
        if (movieTicket == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movieTicket, HttpStatus.OK);
    }
}