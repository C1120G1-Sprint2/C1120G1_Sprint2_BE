package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MovieTicketRepository extends JpaRepository<MovieTicket,Integer> {

    @Query(value =  "select * from movie_ticket " +
                    "where movie_id = ?1 and show_date = ?2 and show_time_id = ?3 ",
            nativeQuery = true)
    MovieTicket getMovieTicket(Integer movieId, String date, Integer showTimeId);

    @Query(value =  "select * from movie_ticket " +
                    "where movie_ticket_id = ?1 ", nativeQuery = true)
    MovieTicket getMovieTicketById(Integer movieTicketId);

    /**
     * Method: get all movie ticket
     * Author: HanTH
     */
    @Query(value = "SELECT * FROM cinema_db.movie_ticket GROUP BY movie_ticket.movie_id;", nativeQuery = true)
    List<MovieTicket> showAllMovieTicket();

    /**
     * Method: get all movie ticket by id
     * Author: HanTH
     *
     * @param movieId
     * @return
     */
    @Query(value = "SELECT * FROM cinema_db.movie_ticket WHERE movie_ticket.movie_id=?1 GROUP BY movie_ticket.show_date ORDER BY movie_ticket.show_date ASC;", nativeQuery = true)
    List<MovieTicket> showAllMovieTicketByMovieId(Integer movieId);

    /**
     * Method: get all movie ticket by id
     * Author: HanTH
     *
     * @param showDate
     * @return
     */
    @Query(value = "SELECT * FROM cinema_db.movie_ticket WHERE movie_ticket.show_date=?1 GROUP BY movie_ticket.movie_id;", nativeQuery = true)
    List<MovieTicket> showAllMovieTicketByShowDate(String showDate);

    /**
     * Method: get all movie by ticket by id and show date
     * Author: HanTH
     *
     * @param movieId
     * @param showDate
     * @return
     */
    @Query(value = "SELECT * FROM cinema_db.movie_ticket WHERE (movie_ticket.movie_id=?1 and movie_ticket.show_date=?2)", nativeQuery = true)
    List<MovieTicket> showAllMovieTicketByMovieIdAndShowDate(Integer movieId, String showDate);

    /**
     * Method: get movie ticket by select
     * Author: HanTH
     *
     * @param movieId
     * @param showDate
     * @param showTimeId
     * @return
     */
    @Query(value = "SELECT * FROM cinema_db.movie_ticket WHERE (movie_ticket.movie_id=?1 and movie_ticket.show_date=?2 and movie_ticket.show_time_id = ?3)", nativeQuery = true)
    MovieTicket showAllMovieTicketBySelect(Integer movieId, String showDate, Integer showTimeId);

    /**
     * Method: get movie ticket by id
     * Author: HanTH
     *
     * @param movieTicketId
     * @return
     */
    @Query(value = "SELECT * FROM cinema_db.movie_ticket WHERE movie_ticket.movie_ticket_id = ?1", nativeQuery = true)
    MovieTicket findMovieTicketById(Integer movieTicketId);

}
