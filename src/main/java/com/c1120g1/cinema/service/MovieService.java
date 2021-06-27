package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAll();

    /**
     * Author: ViNTT
     */
    Page<Movie> findOnShowingMovies(Pageable pageable);

    /**
     * Author: ViNTT
     */
    Page<Movie> findUpComingMovies(Pageable pageable);

    /**
     * Author: ViNTT
     */
    List<Movie> findTop3BySales();

    /**
     * Author: ViNTT
     */
    List<Movie> findPromotingMovies();

    /**
     * Author: ViNTT
     */
    Page<Movie> findByTitleContaining(String keySearch, Pageable pageable);

    /**
     * Author: ViNTT
     */
    Page<Movie> advancedSearch(String keySearch, String categoryId, String date, String showTimeId, Pageable pageable);

    /**
     * Author: ViNTT
     */
    Pageable getPageable(Optional<String> pageParam, Optional<String> pageSizeParam);

}
