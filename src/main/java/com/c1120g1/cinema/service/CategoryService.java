package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Category;

import java.util.List;

public interface CategoryService {


    List<Category> getMovieCategoryById(Integer movieId);

    List<Category> getCategory();


    /**
     * Author: ViNTT
     */
    List<Category> findAll();


}
