package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.MovieTicket;
import com.c1120g1.cinema.repository.MovieTicketRepository;
import com.c1120g1.cinema.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieTicketServiceImpl implements MovieTicketService {

    @Autowired
    private MovieTicketRepository movieTicketRepository;

    @Override
    public MovieTicket getMovieTicket(Integer movieId, String date, Integer showTimeId) {
        return movieTicketRepository.getMovieTicket(movieId, date, showTimeId);
    }
}
