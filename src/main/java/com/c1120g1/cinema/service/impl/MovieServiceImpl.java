package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.entity.dto.MovieDTO;
import com.c1120g1.cinema.repository.MovieCategoryRepository;
import com.c1120g1.cinema.repository.MovieRepository;
import com.c1120g1.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieCategoryRepository movieCategoryRepository;

    @Override
    public Movie getMovieById(Integer id) {
        return movieRepository.getMovieById(id);
    }

    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.getAllMovie();
    }

    @Override
    public Page<Movie> getAllMovieAvailable(Pageable pageable) {
        return movieRepository.getAllMovieAvailable(pageable);
    }

    @Override
    public void addMovie(List<MovieDTO> listMovieDTO) {
        for (MovieDTO movieDTO : listMovieDTO) {
            movieRepository.save(movieDTO.getMovie());
        }

    }

    @Override
    public void setStatus(Integer movieId) {
        movieRepository.setMovieStatusById(movieId);
    }

}
