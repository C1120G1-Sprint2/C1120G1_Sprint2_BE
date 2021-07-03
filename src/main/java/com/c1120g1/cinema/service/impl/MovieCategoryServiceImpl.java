package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.MovieCategory;
import com.c1120g1.cinema.repository.MovieCategoryRepository;
import com.c1120g1.cinema.service.MovieCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCategoryServiceImpl implements MovieCategoryService {

    @Autowired
    private MovieCategoryRepository movieCategoryRepository;


    @Override
    public List<MovieCategory> findAll() {
        return movieCategoryRepository.findAll();
    }

    public void createMovieCategory(Integer movie, Integer category) {
        movieCategoryRepository.createMovieCategory(movie, category);

    }
}
