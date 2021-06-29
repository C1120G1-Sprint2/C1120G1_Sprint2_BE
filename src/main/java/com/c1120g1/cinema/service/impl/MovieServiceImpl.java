package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.entity.dto.MovieDTO;
import com.c1120g1.cinema.repository.MovieCategoryRepository;
import com.c1120g1.cinema.repository.MovieRepository;
import com.c1120g1.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MovieServiceImpl implements MovieService {

    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_PAGE_SIZE = 8;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieCategoryRepository movieCategoryRepository;

    @Override
    public Movie getMovieById(Integer movieId) {
        return movieRepository.getMovieById(movieId);
    }

//    @Override
//    public List<Movie> getAllMovie() {
//        return movieRepository.getAllMovie();
//    }

    @Override
    public Page<Movie> getAllMovieAvailable(Pageable pageable) {
        return movieRepository.getAllMovieAvailable(pageable);
    }

    @Override
    public void addMovie(List<MovieDTO> listMovieDTO) {

        Integer idMovie = listMovieDTO.get(0).getMovie().getMovieId();
        this.movieRepository.save(listMovieDTO.get(0).getMovie());

        for (MovieDTO movieDTO : listMovieDTO) {
            movieCategoryRepository.createMovieCategory(idMovie, movieDTO.getCategoryId());
        }

    }

    @Override
    public void setStatus(Integer movieId) {
        movieRepository.setMovieStatusById(movieId);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    /**
     * Author: ViNTT
     */
    @Override
    public Page<Movie> findOnShowingMovies(Pageable pageable) {
        return movieRepository.findOnShowingMovies(pageable);
    }

    /**
     * Author: ViNTT
     */
    @Override
    public Page<Movie> findUpComingMovies(Pageable pageable) {
        return movieRepository.findUpComingMovies(pageable);
    }

    /**
     * Author: ViNTT
     */
    @Override
    public List<Movie> findTop3BySales() {
        return movieRepository.findTop3BySales();
    }

    /**
     * Author: ViNTT
     */
    @Override
    public List<Movie> findPromotingMovies() {
        return movieRepository.findPromotingMovies();
    }

    /**
     * Author: ViNTT
     */
    @Override
    public Page<Movie> findByTitleContaining(String keySearch, Pageable pageable) {
        return movieRepository.findByTitleContaining(keySearch, pageable);
    }

    /**
     * Author: ViNTT
     */
    @Override
    public Page<Movie> advancedSearch(String keySearch, String categoryId, String date, String showTimeId, Pageable pageable) {
        if (categoryId.equals("")) {
            categoryId = "%" + categoryId + "%";
        }
        if (date.equals("")) {
            date = "%" + date + "%";
        }
        if (showTimeId.equals("")) {
            showTimeId = "%" + showTimeId + "%";
        }
        return movieRepository.findByTitleAndCategoryAndDateAndShowTime(keySearch, categoryId, date, showTimeId, pageable);
    }

    /**
     * Author: ViNTT
     */
    @Override
    public Pageable getPageable(Optional<String> pageParam, Optional<String> pageSizeParam) {
        int page = DEFAULT_PAGE;
        int pageSize = DEFAULT_PAGE_SIZE;

        if (pageParam.isPresent() && !pageParam.get().trim().equals("")) {
            page = Integer.parseInt(pageParam.get().trim());
        }
        if (pageSizeParam.isPresent() && !pageSizeParam.get().trim().equals("")) {
            pageSize = Integer.parseInt(pageSizeParam.get().trim());
        }

        return PageRequest.of(page, pageSize);
    }

    @Override
    public void editMovie(Movie movie) {
        movieRepository.editMovie(movie.getMovieName(), movie.getPosterMovie(), movie.getStartDate(), movie.getEndDate(),
                movie.getMovieStudio(), movie.getActor(), movie.getDirector(), movie.getMovieLength(), movie.getTrailer(),
                movie.getMovieId());

//        for (MovieDTO movieDTO : movie) {
//            movieCategoryRepository.editMovieCategory(temp.getMovieId(), movieDTO.getCategoryId());
//        }
    }
}
