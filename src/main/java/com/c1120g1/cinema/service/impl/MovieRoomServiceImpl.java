package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.MovieRoomRepository;
import com.c1120g1.cinema.service.MovieRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieRoomServiceImpl implements MovieRoomService {

    @Autowired
    private MovieRoomRepository movieRoomRepository;
}
