package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    /**
     * Method: create ticket
     * Author: HanTH
     *
     * @param movieTicketId
     * @param seatId
     * @param userId
     * @param timeCreate
     * @param ticketStatusId
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO cinema_db.ticket(ticket.movie_ticket_id, ticket.seat_id, ticket.user_id, ticket.time_create, ticket.ticket_status_id)\n" +
            "VALUE (?1,?2,?3,?4,?5)", nativeQuery = true)
    void createTicket(Integer movieTicketId, Integer seatId, Integer userId, String timeCreate, Integer ticketStatusId);
}
