package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    @Query(value = "select * \n" +
            "from `ticket`\n" +
            "inner join `user` on `ticket`.user_id = `user`.user_id\n" +
            "inner join `movie_ticket` on `ticket`.movie_ticket_id = `movie_ticket`.movie_ticket_id\n" +
            "inner join `movie` on `movie_ticket`.movie_id = `movie`.movie_id\n" +
            "inner join `movie_status` on `movie`.movie_status_id=`movie_status`.movie_status_id\n" +
            "where username = ?1",nativeQuery = true)
    List<Ticket> findTicketOfUser(String username);

    @Modifying
    @Query(value = "update ticket\n" +
            "set ticket_status_id=3\n" +
            "where ticket_id=?1 and ticket_status_id=1", nativeQuery = true)
    void deleteById(Integer id);
}
