package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.RatingRepository;
import com.c1120g1.cinema.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
}
