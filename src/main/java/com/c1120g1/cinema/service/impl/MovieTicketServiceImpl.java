package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.MovieTicket;
import com.c1120g1.cinema.repository.MovieTicketRepository;
import com.c1120g1.cinema.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class MovieTicketServiceImpl implements MovieTicketService {

    @Autowired
    private MovieTicketRepository movieTicketRepository;

    @Override
    public List<MovieTicket> findAll() {
        return movieTicketRepository.findAll();
    }

    @Override
    public void createMovieTicket(MovieTicket movieTicket) {
        movieTicketRepository.save(movieTicket);
    }

    @Override
    public void checkDuplicate(MovieTicket movieTicket, Errors errors) {
        for (MovieTicket movT : findAll()) {
            if (movT.getShowTime().equals(movieTicket.getShowTime())) {
                errors.rejectValue("showTime", "checkDupShowTime");
            }
        }
    }

    @Override
    public MovieTicket findById(Integer id) {
        return movieTicketRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMovieTicket(Integer id) {
        movieTicketRepository.deleteById(id);
    }

    @Override
    public void editMovieTicket(MovieTicket movieTicket) {
        movieTicketRepository.editMovieTicket(movieTicket.getShowDate(),
                movieTicket.getTicketPrice(),
                movieTicket.getProjectionType().getProjectionId(),
                movieTicket.getRoom().getRoomId(),
                movieTicket.getShowTime().getShowTimeId());
    }
}
