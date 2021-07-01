package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.dto.MemberTicketDTO;
import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.entity.MovieTicket;
import com.c1120g1.cinema.entity.ShowTime;

import com.c1120g1.cinema.entity.Ticket;
import com.c1120g1.cinema.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/api/ticket")
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
    private ShowTimeService showTimeService;



    /**
     * author: QuangHL
     * method: Show list booked ticket
     */
    @GetMapping("/booked-ticket-list/")
    public ResponseEntity<List<Ticket>> getBookedTicketList(@RequestParam("page") int page) {
        List<Ticket> bookedTicketList = ticketService.findAllByBookedTicket(page);
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }

    /**
     * author: QuangHL
     * method: Show list booked ticket no page
     */
    @GetMapping("/booked-ticket-list-no-page")
    public ResponseEntity<List<Ticket>> getBookedTicketListNoPage() {
        List<Ticket> bookedTicketList = ticketService.findAllByBookedTicketNoPage();
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }



    /**
     * author: QuangHL
     * method: Find ticket by ticket id
     */
    @GetMapping("/booked-ticket-list/get-ticket/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("ticketId") Integer ticketId) {
        Ticket bookedTicket = ticketService.findById(ticketId);
        if (bookedTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookedTicket, HttpStatus.OK);
    }

    /**
     * author: QuangHL
     * method: Search by ticket id
     */
    @GetMapping("/booked-ticket-list/search-ticketId")
    public ResponseEntity<Page<Ticket>> searchByTicketId(@RequestParam(name = "ticketId") Integer ticketId, Pageable pageable) {
        Page<Ticket> bookedTicketList = ticketService.searchByTicketId(ticketId, pageable);
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }

    /**
     * author: QuangHL
     * method: Search by user id
     */
    @GetMapping("/booked-ticket-list/search-userId")
    public ResponseEntity<Page<Ticket>> searchByUserId(@RequestParam(name = "userId") Integer userId, Pageable pageable) {
        Page<Ticket> bookedTicketList = ticketService.searchByUserId(userId, pageable);
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }

    /**
     * author: QuangHL
     * method: Search by id card
     */
    @GetMapping("/booked-ticket-list/search-idCard")
    public ResponseEntity<Page<Ticket>> searchByIdCard(@RequestParam(name = "idCard") String idCard, Pageable pageable) {
        Page<Ticket> bookedTicketList = ticketService.searchByIdCard(idCard, pageable);
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }

    /**
     * author: QuangHL
     * method: Search by name customer
     */
    @GetMapping("/booked-ticket-list/search-name")
    public ResponseEntity<Page<Ticket>> searchByName(@RequestParam(name = "name") String name, Pageable pageable) {
        Page<Ticket> bookedTicketList = ticketService.searchByName(name, pageable);
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }

    /**
     * author: QuangHL
     * method: Search by phone number
     */
    @GetMapping("/booked-ticket-list/search-phone")
    public ResponseEntity<Page<Ticket>> searchByPhone(@RequestParam(name = "phone") String phone, Pageable pageable) {
        Page<Ticket> bookedTicketList = ticketService.searchByPhone(phone, pageable);
        if (bookedTicketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookedTicketList, HttpStatus.OK);
    }

    /**
     * author: QuangHL
     * method: Receive booked ticket
     */
    @PutMapping("/booked-ticket-list/get-ticket/confirm-ticket/{ticketId}")
    public ResponseEntity<Ticket> receiveBookedTicket(@PathVariable("ticketId") Integer ticketId) {
        Ticket receivedTicket = ticketService.findById(ticketId);
        if (receivedTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.ticketService.receiveBookedTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * author: QuangHL
     * method: Print ticket by ticket id
     */
    @GetMapping("/booked-ticket-list/get-ticket/print-ticket/{ticketId}")
    public ResponseEntity<Ticket> printTicketById(@PathVariable("ticketId") Integer ticketId) {
        Ticket printTicket = ticketService.findTicketByTicketId(ticketId);
        if (printTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(printTicket, HttpStatus.OK);
    }

    /**
     * author: QuangHL
     * method: Cancel booked ticket
     */
    @PutMapping("/booked-ticket-list/cancel-ticket/{ticketId}")
    public ResponseEntity<Ticket> cancelBookedTicket(@PathVariable("ticketId") Integer ticketId) {
        Ticket receivedTicket = ticketService.findById(ticketId);
        if (receivedTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.ticketService.cancelBookedTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * author : HoangTQ
     * method : getListMovie()
     * @return : listMovie
     */
    @GetMapping("/listMovie")
    public ResponseEntity<List<Movie>> getListMovie(){
        try {
            List<Movie> listMovie = movieService.findAll();
            if (listMovie.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listMovie, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * author : HoangTQ
     * method : getListShowTime()
     * @param date : the date time
     * @param movieId : id of a movie
     * @return : listShowTime
     */
    @GetMapping("/listShowTime/{date}/{movieId}")
    public ResponseEntity<List<ShowTime>> getListShowTime(@PathVariable(name = "date") String date,
                                                          @PathVariable(name = "movieId") Integer movieId){
        try {
            List<ShowTime> listShowTime = showTimeService.getAllShowTimeByDateAndMovie(date, movieId);
            if (listShowTime.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listShowTime, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * author : HoangTQ
     * method : getMovieTicket()
     * @param movieId : id of a movie
     * @param date : the date time
     * @param showTimeId : if of a showTime
     * @return a movieTicket object
     */
    @GetMapping("/movieTicket/{movieId}/{date}/{showTimeId}")
    public ResponseEntity<MovieTicket> getMovieTicket(@PathVariable(name = "movieId") Integer movieId,
                                                      @PathVariable(name = "date") String date,
                                                      @PathVariable(name = "showTimeId") Integer showTimeId){
        try {
            MovieTicket movieTicket = this.movieTicketService.getMovieTicket(movieId, date, showTimeId);
            if (movieTicket == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieTicket, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * author : HoangTQ
     * method : getMovieTicketById()
     * @param movieTicketId : if of a Movie
     * @return a movieTicket object
     */
    @GetMapping("/getMovieTicket/{movieTicketId}")
    public ResponseEntity<MovieTicket> getMovieTicketById(@PathVariable(name = "movieTicketId") Integer movieTicketId){
        try {
            MovieTicket movieTicket = this.movieTicketService.getMovieTicketById(movieTicketId);
            if (movieTicket == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieTicket, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/createTicketDTO/{movieTicketId}/{userId}/{seatId}")
    public ResponseEntity<Void> createTicketDTO(@PathVariable(name = "movieTicketId") Integer movieTicketId,
                                                @PathVariable(name = "userId") Integer userId,
                                                @PathVariable(name = "seatId") Integer seatId) {
        try {
            this.ticketService.saveTicketDTO( movieTicketId, userId, seatId );
            MovieTicket movieTicket = this.movieTicketService.getMovieTicketById( movieTicketId );
            this.roomSeatService.updateRoomSeatStatus( seatId, movieTicket.getRoom().getRoomId() );
            return new ResponseEntity<>( HttpStatus.CREATED );
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
    /**
     * Method: create ticket
     * Author: HanTH
     *
     * @param memberTicketDTO
     * @return
     */
    @PostMapping("/saleTicket/createTicket/{roomId}")
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

    @GetMapping("/listShowTime/{date}")
    public ResponseEntity<List<ShowTime>> getListShowTime(@PathVariable(name = "date") String date){
        List<ShowTime> listShowTime = showTimeService.getAllShowTimeByDate(date);
        if (listShowTime.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listShowTime, HttpStatus.OK);
    }


}
