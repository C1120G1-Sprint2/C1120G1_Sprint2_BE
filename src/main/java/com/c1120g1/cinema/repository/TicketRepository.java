package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.dto.TicketDTO;
import com.c1120g1.cinema.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    /**
     * author: QuangHL
     * method: Show list booked ticket
     */
    @Query(value = "SELECT * " +
            "FROM ticket WHERE ticket.ticket_status_id = 2 GROUP BY ticket_id limit ?1, 3", nativeQuery = true)
    List<Ticket> findAllByBookedTicket(int index);

    /**
     * author: QuangHL
     * method: Show list booked ticket no page
     */
    @Query(value = "SELECT * " +
            "FROM ticket WHERE ticket.ticket_status_id = 2 GROUP BY ticket_id", nativeQuery = true)
    List<Ticket> findAllByBookedTicketNoPage();

    /**
     * author: QuangHL
     * method: Search by ticket id
     */
    @Query(value = "SELECT * " +
            "FROM ticket WHERE ticket_status_id = 2 AND ticket_id = ?1", nativeQuery = true)
    Page<Ticket> searchByTicketId(Integer ticketId, Pageable pageable);

    /**
     * author: QuangHL
     * method: Search by user id
     */
    @Query(value = "SELECT * " +
            "FROM ticket WHERE ticket_status_id = 2 AND user_id = ?1", nativeQuery = true)
    Page<Ticket> searchByUserId(Integer userId, Pageable pageable);

    /**
     * author: QuangHL
     * method: Search by id card
     */
    @Query(value = "SELECT * " +
            "FROM ticket " +
            "INNER JOIN `user` ON `user`.user_id = ticket.user_id " +
            "WHERE ticket_status_id = 2 AND `user`.id_card = ?1", nativeQuery = true)
    Page<Ticket> searchByIdCard(String idCard, Pageable pageable);

    /**
     * author: QuangHL
     * method: Search by phone number
     */
    @Query(value = "SELECT * " +
            "FROM ticket " +
            "INNER JOIN `user` ON `user`.user_id = ticket.user_id " +
            "WHERE ticket_status_id = 2 AND `user`.phone = ?1", nativeQuery = true)
    Page<Ticket> searchByPhone(String phone, Pageable pageable);

    /**
     * author: QuangHL
     * method: Print ticket by ticket id
     */
    @Query(value = "SELECT * " +
            "FROM ticket WHERE ticket_status_id = 3 AND ticket.ticket_id = ?1", nativeQuery = true)
    Ticket findTicketByTicketId(Integer ticketId);

    /**
     * author: QuangHL
     * method: Receive booked ticket
     */
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE ticket " +
            "SET ticket.ticket_status_id = 3 " +
            "WHERE ticket.ticket_id = ?1", nativeQuery = true)
    void receiveBookedTicket(Integer ticketId);

    /**
     * author: QuangHL
     * method: Cancel booked ticket
     */
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE ticket " +
            "SET ticket_status_id = 4 " +
            "WHERE ticket_id = ?1", nativeQuery = true)
    void cancelBookedTicket(Integer ticketId);

}
