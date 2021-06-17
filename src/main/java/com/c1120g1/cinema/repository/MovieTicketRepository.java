package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieTicketRepository extends JpaRepository<MovieTicket, Integer> {
    /**
     * Method: get all movie ticket
     * Author: HanTH
     */
    @Query(value = "SELECT * FROM cinema_db.movie_ticket", nativeQuery = true)
    List<MovieTicket> showAllMovieTicket();

    /**
     * Method: get all movie ticket by id
     * Author: HanTH
     *
     * @param movieId
     * @return
     */
    @Query(value = "SELECT * FROM cinema_db.movie_ticket WHERE movie_ticket.movie_ticket_id=?1", nativeQuery = true)
    List<MovieTicket> showAllMovieTicketById(Integer movieId);

    /**
     * Method: get all movie by ticket by id and show date
     * Author: HanTH
     *
     * @param movieId
     * @param showDate
     * @return
     */
    @Query(value = "SELECT * FROM cinema_db.movie_ticket WHERE movie_ticket.movie_id=?1 and WHERE movie_ticket.show_date=?2", nativeQuery = true)
    List<MovieTicket> showAllMovieTicketByIdAndShowDate(Integer movieId, String showDate);
}
