package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MovieTicketRepository extends JpaRepository<MovieTicket,Integer> {
    @Modifying
    @Query(value = "update movie_ticket " +
            "set show_date = ?1, " +
            "ticket_price = ?2, " +
            "projection_type_id = ?3, " +
            "room_id = ?4, " +
            "show_time_id = ?5 where movie_ticket_id = ?6;", nativeQuery = true)
    void editMovieTicket(String showDate, String ticketPrice, Integer projectionId, Integer roomId, Integer showTimeId);

}
