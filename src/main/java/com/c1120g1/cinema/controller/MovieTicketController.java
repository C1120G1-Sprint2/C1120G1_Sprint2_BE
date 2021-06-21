package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.dto.MovieTicketDTO;
import com.c1120g1.cinema.entity.MovieTicket;
import com.c1120g1.cinema.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieTicketController {
    @Autowired
    private MovieTicketService movieTicketService;

    @GetMapping("/api/admin/movie-ticket")
    public ResponseEntity<?> getAllMovieTicket() {
        try {
            List<MovieTicket> movieTicketList = this.movieTicketService.findAll();
            return new ResponseEntity<>(movieTicketList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping(value = "/api/admin/movie-ticket/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MovieTicket> getMovieTicketById(@PathVariable("id") Integer id) {
        MovieTicket movieTicket = this.movieTicketService.findById(id);
        if (movieTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(movieTicket,HttpStatus.OK);
    }

    @PostMapping(value = "/api/admin/movie-ticket/create")
    public ResponseEntity<Void> createMovieTicket(@RequestBody MovieTicket movieTicket, BindingResult bindingResult) {
        this.movieTicketService.checkDuplicate(movieTicket, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        try {

            this.movieTicketService.createMovieTicket(movieTicket);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/api/admin/movie-ticket/delete/{id}")
    public ResponseEntity<MovieTicket> deleteMovieTicket(@PathVariable("id") Integer id) {
        MovieTicket deleteMovieTicket = this.movieTicketService.findById(id);
        if (deleteMovieTicket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieTicketService.deleteMovieTicket(id);
        return new ResponseEntity<>(deleteMovieTicket, HttpStatus.OK);
    }

    @PutMapping(value = "/api/admin/movie-ticket/edit/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MovieTicket> editMovieTicket(@PathVariable("id") Integer id, @RequestBody MovieTicket movieTicket) {
        try {
            MovieTicket editMovieTicket = this.movieTicketService.findById(id);
            if (editMovieTicket != null) {
                movieTicket.setMovieTicketId(id);
                this.movieTicketService.editMovieTicket(movieTicket);
                return new ResponseEntity<>(movieTicket, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
