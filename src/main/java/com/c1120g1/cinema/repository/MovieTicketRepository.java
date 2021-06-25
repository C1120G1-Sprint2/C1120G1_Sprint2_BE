package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieTicketRepository extends JpaRepository<MovieTicket,Integer> {

    @Query(value =  "select * from movie_ticket " +
                    "where movie_id = ?1 and show_date = ?2 and show_time_id = ?3 ",
            nativeQuery = true)
    MovieTicket getMovieTicket(Integer movieId, String date, Integer showTimeId);

    @Query(value =  "select * from movie_ticket " +
                    "where movie_ticket_id = ?1 ", nativeQuery = true)
    MovieTicket getMovieTicketById(Integer movieTicketId);
}
