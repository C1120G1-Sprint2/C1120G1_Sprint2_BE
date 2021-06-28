package com.c1120g1.cinema.controller;
import com.c1120g1.cinema.entity.Ticket;
import com.c1120g1.cinema.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping(value = "/booking",params = {"page","username"})
    public ResponseEntity<Page<Ticket>> getListTickets(
            @RequestParam ("username") String username, Pageable pageable) {
        Page <Ticket> tickets = ticketService.findAllTicketByUsername(pageable,username);
        if (tickets==null) {
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
}
