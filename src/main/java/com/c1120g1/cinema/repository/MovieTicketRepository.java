package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.MovieTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface MovieTicketRepository extends JpaRepository<MovieTicket,Integer> {
    @Transactional
    @Modifying
    @Query(value = "update movie_ticket " +
            "set show_date = ?1, " +
            "ticket_price = ?2, " +
            "projection_type_id = ?3, " +
            "room_id = ?4, " +
            "show_time_id = ?5 " +
            "where movie_ticket_id = ?6", nativeQuery = true)
    void editMovieTicket(String showDate,
                         Integer ticketPrice,
                         Integer projectionId,
                         Integer roomId,
                         Integer showTimeId,
                         Integer movieTicketId);


    @Query(value = "select * from movie_ticket " +
            "inner join movie on movie_ticket.movie_id  = movie.movie_id " +
            "inner join projection_type on movie_ticket.projection_type_id = projection_type.projection_type_id " +
            "inner join room on movie_ticket.room_id = room.room_id " +
            "inner join show_time on movie_ticket.show_time_id = show_time.show_time_id " +
            "where concat (movie_ticket_id, show_date, ticket_price, movie.movie_name, projection_type.projection_type_name, room.room_name, show_time.show_time) like concat ('%',?1,'%')",
    nativeQuery = true)
    Page<MovieTicket> searchMovieTicket(Pageable pageable, String q);


    @Modifying
    @Query(value = "insert into movie_ticket (movie_id, show_date, projection_type_id, room_id, show_time_id, ticket_price) " +
            "value (?1,?2,?3, ?4, ?5, ?6)", nativeQuery =true)
    @Transactional
    void createMovieTicket(Integer movieId,
                           String showDate,
                           Integer projectionId,
                           Integer roomId,
                           Integer showTimeId,
                           Integer ticketPrice);


    @Modifying
    @Query(value = "SELECT * FROM movie_ticket " +
            "where show_date = ?1", nativeQuery = true)
    List<MovieTicket> findAllMovieTicketByDate(String showDate);



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
