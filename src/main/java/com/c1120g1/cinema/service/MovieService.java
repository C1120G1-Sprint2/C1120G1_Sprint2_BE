package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    Movie findById(Integer id);
}
