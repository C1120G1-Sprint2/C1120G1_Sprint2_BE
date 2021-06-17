package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.MovieTicket;
import com.c1120g1.cinema.repository.MovieTicketRepository;
import com.c1120g1.cinema.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieTicketServiceImpl implements MovieTicketService {

    @Autowired
    private MovieTicketRepository movieTicketRepository;

    /**
     * Method: get all movie ticket
     * Author: HanTH
     *
     * @return
     */
    @Override
    public List<MovieTicket> showAllMovieTicket() {
        return movieTicketRepository.showAllMovieTicket();
    }

    /**
     * Method: get all movie ticket by id
     * Author: HanTH
     *
     * @param movieId
     * @return
     */
    @Override
    public List<MovieTicket> showAllMovieTicketById(Integer movieId) {
        return movieTicketRepository.showAllMovieTicketById( movieId );
    }

    /**
     * Method: get all movie ticket by id and show date
     *
     * @param movieId
     * @param showDate
     * @return
     */
    @Override
    public List<MovieTicket> showAllMovieTicketByIdAndShowDate(Integer movieId, String showDate) {
        return movieTicketRepository.showAllMovieTicketByIdAndShowDate( movieId, showDate );
    }
}
