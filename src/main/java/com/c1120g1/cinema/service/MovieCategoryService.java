package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.MovieCategory;

import java.util.List;

public interface MovieCategoryService {


    List<MovieCategory> findAll();

    void createMovieCategory(Integer movie, Integer category);

}
