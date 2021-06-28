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

    @Override
    public MovieTicket getMovieTicket(Integer movieId, String date, Integer showTimeId) {
        return movieTicketRepository.getMovieTicket(movieId, date, showTimeId);
    }

    @Override
    public MovieTicket getMovieTicketById(Integer movieTicketId) {
        return movieTicketRepository.getMovieTicketById( movieTicketId );
    }

    /**
     * Method: get all movie ticket
     * Author: HanTH
     *
     * @return
     */
    @Override
    public List<MovieTicket> showAllMovieTicket(){
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
    public List<MovieTicket> showAllMovieTicketByMovieId(Integer movieId) {
        return movieTicketRepository.showAllMovieTicketByMovieId( movieId );
    }

    /**
     * Method: get all movie ticket by id
     * Author: HanTH
     *
     * @param showDate
     * @return
     */
    @Override
    public List<MovieTicket> showAllMovieTicketByShowDate(String showDate) {
        return movieTicketRepository.showAllMovieTicketByShowDate( showDate );
    }

    /**
     * Method: get all movie ticket by id and show date
     *
     * @param movieId
     * @param showDate
     * @return
     */
    @Override
    public List<MovieTicket> showAllMovieTicketByMovieIdAndShowDate(Integer movieId, String showDate) {
        return movieTicketRepository.showAllMovieTicketByMovieIdAndShowDate( movieId, showDate );
    }

    @Override
    public MovieTicket findMovieTicketById(Integer movieTicketId) {
        return movieTicketRepository.findMovieTicketById( movieTicketId );
    }

    @Override
    public MovieTicket findMovieTicketBySelect(Integer movieId, String showDate, Integer showTimeId) {
        return movieTicketRepository.showAllMovieTicketBySelect(movieId,showDate,showTimeId );
    }
}
