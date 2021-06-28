package com.c1120g1.cinema.controller;


import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import com.c1120g1.cinema.entity.Category;
import com.c1120g1.cinema.entity.dto.MovieDTO;
import com.c1120g1.cinema.service.CategoryService;
import com.c1120g1.cinema.service.MovieCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MovieCategoryService movieCategoryService;


    @GetMapping("/admin/list-movie")
    public ResponseEntity<?> getAllMovies() {
        try {
            List<Movie> movieList = this.movieService.findAll();
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/detail-movie/{id}")
    public ResponseEntity<Movie> getMovieByIdm(@PathVariable("id") Integer id) {
        Movie movie = this.movieService.findById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

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
     * Author: ViNTT
     */
    @GetMapping("/on-showing")
    public ResponseEntity<Page<Movie>> getOnShowingMovies(@RequestParam("page") Optional<String> pageParam,
                                                          @RequestParam("size") Optional<String> pageSizeParam) {
        try {
            Pageable pageable = movieService.getPageable(pageParam, pageSizeParam);
            Page<Movie> movieList = movieService.findOnShowingMovies(pageable);
            if (movieList == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author: ViNTT
     */
    @GetMapping("/up-coming")
    public ResponseEntity<Page<Movie>> getUpComingMovies(@RequestParam("page") Optional<String> pageParam,
                                                         @RequestParam("size") Optional<String> pageSizeParam) {
        try {
            Pageable pageable = movieService.getPageable(pageParam, pageSizeParam);
            Page<Movie> movieList = movieService.findUpComingMovies(pageable);
            if (movieList == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author: ViNTT
     */
    @GetMapping("/top-3")
    public ResponseEntity<List<Movie>> getTop3BySales() {
        try {
            List<Movie> movieList = movieService.findTop3BySales();
            if (movieList == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author: ViNTT
     */
    @GetMapping("/promoting")
    public ResponseEntity<List<Movie>> getPromotingMovies() {
        try {
            List<Movie> movieList = movieService.findPromotingMovies();
            if (movieList == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
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
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Author: ViNTT
     */
    @GetMapping("/search")
    public ResponseEntity<Page<Movie>> searchByKey(@RequestParam("q") Optional<String> keySearchParam,
                                                   @RequestParam("page") Optional<String> pageParam,
                                                   @RequestParam("size") Optional<String> pageSizeParam) {
        try {
            String keySearch = "";
            if (keySearchParam.isPresent()) {
                keySearch = keySearchParam.get().trim();
            }

            Pageable pageable = movieService.getPageable(pageParam, pageSizeParam);
            Page<Movie> movieList = movieService.findByTitleContaining(keySearch, pageable);
            if (movieList == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();

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

    /**
     * Author:
     * ViNTT
     */
    @GetMapping("/advancedSearch")
    public ResponseEntity<Page<Movie>> advancedSearch
    (@RequestParam("q") Optional<String> keySearchParam,
     @RequestParam("categoryId") Optional<String> categoryIdParam,
     @RequestParam("date") Optional<String> dateParam,
     @RequestParam("showTimeId") Optional<String> showTimeIdParam,
     @RequestParam("page") Optional<String> pageParam,
     @RequestParam("size") Optional<String> pageSizeParam) {
        try {
            String keySearch = "";
            String categoryId = "";
            String date = "";
            String showTimeId = "";

            if (keySearchParam.isPresent()) {
                keySearch = keySearchParam.get().trim();
            }
            if (categoryIdParam.isPresent()) {
                categoryId = categoryIdParam.get().trim();
            }
            if (dateParam.isPresent()) {
                date = dateParam.get().trim();
            }
            if (showTimeIdParam.isPresent()) {
                showTimeId = showTimeIdParam.get().trim();
            }

            Pageable pageable = movieService.getPageable(pageParam, pageSizeParam);
            Page<Movie> movieList = movieService.advancedSearch(keySearch, categoryId, date, showTimeId, pageable);
            if (movieList == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

