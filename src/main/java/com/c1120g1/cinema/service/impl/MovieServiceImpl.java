package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Movie;
import com.c1120g1.cinema.entity.Ticket;
import com.c1120g1.cinema.repository.MovieRepository;
import com.c1120g1.cinema.repository.TicketRepository;
import com.c1120g1.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    private TicketRepository ticketRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

}
