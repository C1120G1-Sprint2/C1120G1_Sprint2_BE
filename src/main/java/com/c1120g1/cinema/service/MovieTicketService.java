package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.MovieTicket;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.util.List;

public interface MovieTicketService {
    List<MovieTicket> findAll();

    void createMovieTicket(MovieTicket movieTicket);

    void checkDuplicate(MovieTicket movieTicket, Errors errors);

    MovieTicket findById(Integer id);

    void deleteMovieTicket(Integer id);

    void editMovieTicket(MovieTicket movieTicket);
}
