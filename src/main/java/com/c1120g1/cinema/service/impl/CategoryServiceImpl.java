package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.CategoryRepository;
import com.c1120g1.cinema.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
}
