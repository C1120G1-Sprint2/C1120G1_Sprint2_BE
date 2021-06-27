package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.entity.dto.MovieDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface MovieService {


    Movie getMovieById(Integer id);

    List<Movie> getAllMovie();

    Page<Movie> getAllMovieAvailable(Pageable pageable);

    void addMovie(List<MovieDTO> movie);

    void setStatus(Integer movieId);




}
