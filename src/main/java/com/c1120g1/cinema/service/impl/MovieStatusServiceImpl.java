package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.MovieStatusRepository;
import com.c1120g1.cinema.service.MovieStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieStatusServiceImpl implements MovieStatusService {

    @Autowired
    private MovieStatusRepository movieStatusRepository;
}
