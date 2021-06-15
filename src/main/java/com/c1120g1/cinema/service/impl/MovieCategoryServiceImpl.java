package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.MovieCategoryRepository;
import com.c1120g1.cinema.service.MovieCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieCategoryServiceImpl implements MovieCategoryService {

    @Autowired
    private MovieCategoryRepository movieCategoryRepository;
}
