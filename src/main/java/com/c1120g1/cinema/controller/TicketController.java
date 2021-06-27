package com.c1120g1.cinema.controller;
import com.c1120g1.cinema.entity.Ticket;
import com.c1120g1.cinema.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/member")
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

    @GetMapping("/booking/{username}")
    public ResponseEntity<List<Ticket>> getListTickets(@PathVariable("username") String username){
       List <Ticket> tickets = ticketService.findAllTicketByUsername(username);
        if (tickets==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
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
}
