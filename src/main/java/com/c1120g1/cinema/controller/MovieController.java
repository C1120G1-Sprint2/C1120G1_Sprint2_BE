package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/admin/list-movie")
    public ResponseEntity<?> getAllMovie() {
        try {
            List<Movie> movieList = this.movieService.findAll();
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/detail-movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Integer id) {
        Movie movie = this.movieService.findById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}
