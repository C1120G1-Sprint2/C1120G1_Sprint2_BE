package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.MovieTicket;

public interface MovieTicketService {

    MovieTicket getMovieTicket(Integer movieId, String date, Integer showTimeId);

    MovieTicket getMovieTicketById(Integer movieTicketId);
}
