package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.MovieTicket;

import java.util.List;

public interface MovieTicketService {
    //    HanTH
    List<MovieTicket> showAllMovieTicket();

    List<MovieTicket> showAllMovieTicketById(Integer movieId);

    List<MovieTicket> showAllMovieTicketByIdAndShowDate(Integer movieId, String showDate);

//    HanTH

}
