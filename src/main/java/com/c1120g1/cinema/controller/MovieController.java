package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Category;
import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.entity.dto.MovieDTO;
import com.c1120g1.cinema.service.CategoryService;
import com.c1120g1.cinema.service.MovieCategoryService;
import com.c1120g1.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MovieCategoryService movieCategoryService;

    /**
     * Author : ThinhTHB
     * function to set status
     */
    @PutMapping("/set_status/{id}")
    public void setMovieStatus(@PathVariable("id") Integer id) {
         movieService.setStatus(id);
    }

    /**
     * Author : ThinhTHB
     * function to get category
     */
    @GetMapping("/category")
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }

    /**
     * Author : ThinhTHB
     * function to get movie by id
     */
    @GetMapping("/movie_id/{id}")
    public Movie getMovieById(@PathVariable Integer id) {
        return movieService.getMovieById(id);
    }


    /**
     * Author : ThinhTHB
     * function to get all movie
     */
    @GetMapping("/all_movie")
    public ResponseEntity<List<Movie>> getAllMovie() {
        try {
            List<Movie> movie = movieService.getAllMovie();
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author : ThinhTHB
     * function to get movie available
     */
    @GetMapping("/movie_ava")
    public ResponseEntity<Page<Movie>> getAllMovieAvailable(@PageableDefault(size = 5) Pageable pageable) {
        try {
            Page<Movie> movieAva = movieService.getAllMovieAvailable(pageable);
            return new ResponseEntity<>(movieAva, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author : ThinhTHB
     * function to add movie
     */
    @PostMapping("/add_movie")
    public ResponseEntity<Void> addMovie(@RequestBody List<MovieDTO> listMovieDTO) {
        try {
            movieService.addMovie(listMovieDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
