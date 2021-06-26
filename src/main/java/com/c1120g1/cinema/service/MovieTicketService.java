package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.MovieTicket;

import java.util.List;

public interface MovieTicketService {

    MovieTicket getMovieTicket(Integer movieId, String date, Integer showTimeId);

    MovieTicket getMovieTicketById(Integer movieTicketId);

    //    HanTH
    List<MovieTicket> showAllMovieTicket();

    List<MovieTicket> showAllMovieTicketByMovieId(Integer movieId);

    List<MovieTicket> showAllMovieTicketByMovieIdAndShowDate(Integer movieId, String showDate);

    MovieTicket findMovieTicketById(Integer movieTicketId);

    MovieTicket findMovieTicketBySelect(Integer movieId, String showDate, Integer showTimeId);

//   HanTH
}

