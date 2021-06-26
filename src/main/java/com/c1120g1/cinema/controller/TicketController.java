package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.dto.MemberTicketDTO;
import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.entity.Seat;
import com.c1120g1.cinema.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private RoomSeatService roomSeatService;

    @Autowired
    private MovieTicketService movieTicketService;

    @Autowired
    private TicketStatusService ticketStatusService;

    @Autowired
    private ShowTimeService showTimeService;

    @GetMapping("/api/booking/listMovie")
    public ResponseEntity<List<Movie>> getListMovie() {
        List<Movie> listMovie = movieService.findAll();
        if (listMovie.isEmpty()) {
            return new ResponseEntity<>( HttpStatus.NO_CONTENT );
        }
        return new ResponseEntity<>( listMovie, HttpStatus.OK );
    }

    /**
     * Method: create ticket
     * Author: HanTH
     *
     * @param memberTicketDTO
     * @return
     */
    @PostMapping("/api/employee/saleTicket/createTicket/{roomId}")
    public ResponseEntity<Void> createTicket(@RequestBody List<MemberTicketDTO> memberTicketDTO, @PathVariable Integer roomId) {
        try {
            for (MemberTicketDTO ticketDTO : memberTicketDTO) {
                ticketService.createTicket( ticketDTO );
                roomSeatService.updateStatusSeat( roomId, ticketDTO.getSeatId(), 2 );
            }
            return new ResponseEntity<>( HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }

}
