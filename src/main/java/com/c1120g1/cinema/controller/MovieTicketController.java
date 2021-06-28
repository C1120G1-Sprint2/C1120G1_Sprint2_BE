package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.MovieTicket;
import com.c1120g1.cinema.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/admin")
public class MovieTicketController {
    @Autowired
    private MovieTicketService movieTicketService;

//   danh sach movie-ticket co phan trang - sorting
    @GetMapping(value = "/movie-ticket", params = {"page", "size", "onSorting", "textSorting"})
    public ResponseEntity<Page<MovieTicket>> getAllMovieTicket(@RequestParam("page") int page,
                                                               @RequestParam("size") int size,
                                                               @RequestParam("onSorting") boolean onSorting,
                                                               @RequestParam("textSorting") String textSorting) {
        try {
            Page<MovieTicket> movieTickets;
            if (textSorting.equals("")) {
                movieTickets = movieTicketService.findAllMovieTicket(PageRequest.of(page, size));
            } else {
                if (!onSorting) {
                    movieTickets = movieTicketService.findAllMovieTicket(PageRequest.of(page, size, Sort.by(textSorting).ascending()));

                } else {
                    movieTickets = movieTicketService.findAllMovieTicket(PageRequest.of(page, size, Sort.by(textSorting).descending()));
                }
            }
            if (movieTickets.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(movieTickets, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping(value = "/movie-ticket/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MovieTicket> getMovieTicketById(@PathVariable("id") Integer id) {
        MovieTicket movieTicket = this.movieTicketService.findById(id);
        if (movieTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(movieTicket,HttpStatus.OK);
    }

    @PostMapping(value = "/movie-ticket/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> createMovieTicket(@RequestBody List<MovieTicket> movieTicketList, BindingResult bindingResult) {
//        this.movieTicketService.checkDuplicate(movieTicket, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
        try {
            for (MovieTicket movieTicket: movieTicketList) {
                movieTicketService.createMovieTicket(movieTicket);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/movie-ticket/delete/{id}")
    public ResponseEntity<MovieTicket> deleteMovieTicket(@PathVariable("id") Integer id) {
        MovieTicket deleteMovieTicket = this.movieTicketService.findById(id);
        if (deleteMovieTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieTicketService.deleteMovieTicket(id);
        return new ResponseEntity<>(deleteMovieTicket, HttpStatus.OK);
    }

    @PutMapping(value = "/movie-ticket/edit/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MovieTicket> editMovieTicket(@PathVariable("id") Integer id, @RequestBody MovieTicket movieTicket) {
        try {
            MovieTicket editMovieTicket = this.movieTicketService.findById(id);
            if (editMovieTicket != null) {
                this.movieTicketService.editMovieTicket(movieTicket);
                return new ResponseEntity<>(movieTicket, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/movie-ticket/search", params = {"size", "q"})
    public ResponseEntity<Page<MovieTicket>> searchMovieTicket(@RequestParam("q") String q, @RequestParam("size") int size) {
        try {
            Page<MovieTicket> movieTicketList = this.movieTicketService.searchMovieTicket(PageRequest.of(0,size), q);
            if (movieTicketList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(movieTicketList, HttpStatus.OK);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
