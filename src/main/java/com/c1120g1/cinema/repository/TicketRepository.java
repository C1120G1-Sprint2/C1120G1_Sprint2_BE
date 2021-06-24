package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    /**
     * author: QuangHL
     * method: Show list booked ticket
     */
    @Query(value = "SELECT * " +
            "FROM ticket WHERE ticket.ticket_status_id = 2", nativeQuery = true)
    Page<Ticket> findAllByBookedTicket(Pageable pageable);


    /**
     * author: QuangHL
     * method: Search by ticket id
     */
    @Query(value = "SELECT ticket.ticket_id, " + "`user`.user_id, " + "`user`.`name`, " + "`user`.id_card," +
            "movie.movie_name, " + "movie_ticket.show_date," + "show_time.show_time " +
            "FROM ticket " +
            "INNER JOIN `user` ON `user`.user_id = ticket.user_id " +
            "INNER JOIN movie_ticket ON movie_ticket.movie_ticket_id = ticket.movie_ticket_id " +
            "INNER JOIN movie ON movie.movie_id = movie_ticket.movie_id " +
            "INNER JOIN show_time ON show_time.show_time_id = movie_ticket.show_time_id " +
            "WHERE ticket.ticket_id = ?1 " +
            "AND ticket.ticket_status_id = 2", nativeQuery = true)
    Page<Ticket> searchByTicketId(Integer ticketId, Pageable pageable);

    /**
     * author: QuangHL
     * method: Search by user id
     */
    @Query(value = "SELECT ticket.ticket_id, " + "`user`.user_id, " + "`user`.`name`, " + "`user`.id_card," +
            "movie.movie_name, " + "movie_ticket.show_date," + "show_time.show_time " +
            "FROM ticket " +
            "INNER JOIN `user` ON `user`.user_id = ticket.user_id " +
            "INNER JOIN movie_ticket ON movie_ticket.movie_ticket_id = ticket.movie_ticket_id " +
            "INNER JOIN movie ON movie.movie_id = movie_ticket.movie_id " +
            "INNER JOIN show_time ON show_time.show_time_id = movie_ticket.show_time_id " +
            "WHERE `user`.user_id = ?1 " +
            "AND ticket.ticket_status_id = 2", nativeQuery = true)
    Page<Ticket> searchByUserId(Integer userId, Pageable pageable);

    /**
     * author: QuangHL
     * method: Search by id card
     */
    @Query(value = "SELECT ticket.ticket_id, " + "`user`.user_id, " + "`user`.`name`, " + "`user`.id_card," +
            "movie.movie_name, " + "movie_ticket.show_date," + "show_time.show_time " +
            "FROM ticket " +
            "INNER JOIN `user` ON `user`.user_id = ticket.user_id " +
            "INNER JOIN movie_ticket ON movie_ticket.movie_ticket_id = ticket.movie_ticket_id " +
            "INNER JOIN movie ON movie.movie_id = movie_ticket.movie_id " +
            "INNER JOIN show_time ON show_time.show_time_id = movie_ticket.show_time_id " +
            "WHERE `user`.id_card = ?1 " +
            "AND ticket.ticket_status_id = 2", nativeQuery = true)
    Page<Ticket> searchByIdCard(String idCard, Pageable pageable);

    /**
     * author: QuangHL
     * method: Search by phone number
     */
    @Query(value = "SELECT ticket.ticket_id, " + "`user`.user_id, " + "`user`.`name`, " + "`user`.id_card," +
            "movie.movie_name, " + "movie_ticket.show_date," + "show_time.show_time " +
            "FROM ticket " +
            "INNER JOIN `user` ON `user`.user_id = ticket.user_id " +
            "INNER JOIN movie_ticket ON movie_ticket.movie_ticket_id = ticket.movie_ticket_id " +
            "INNER JOIN movie ON movie.movie_id = movie_ticket.movie_id " +
            "INNER JOIN show_time ON show_time.show_time_id = movie_ticket.show_time_id " +
            "WHERE `user`.phone = ?1 " +
            "AND ticket.ticket_status_id = 2", nativeQuery = true)
    Page<Ticket> searchByPhone(String phone, Pageable pageable);

    /**
     * author: QuangHL
     * method: Find ticket by ticket id
     */
    @Query(value = "SELECT ticket.ticket_id, " + "`user`.user_id, " + "`user`.`name`, " + "`user`.id_card, " +
            "movie.movie_name, " + "movie_ticket.show_date," + "show_time.show_time, " + "room.room_name, " +
            "`account`.`point`, " + "`row`.row_name, " + "`column`.`column_name` " +
            "FROM ticket " +
            "INNER JOIN `user` ON `user`.user_id = ticket.user_id " +
            "INNER JOIN movie_ticket ON movie_ticket.movie_ticket_id = ticket.movie_ticket_id " +
            "INNER JOIN movie ON movie.movie_id = movie_ticket.movie_id " +
            "INNER JOIN show_time ON show_time.show_time_id = movie_ticket.show_time_id " +
            "INNER JOIN room ON room.room_id = movie_ticket.room_id " +
            "INNER JOIN `account` ON `account`.username  = `user`.username " +
            "INNER JOIN seat ON seat.seat_id = ticket.seat_id " +
            "INNER JOIN `row` ON `row`.row_id = seat.row_id " +
            "INNER JOIN `column` ON `column`.column_id = seat.column_id " +
            "WHERE ticket.ticket_id = ?1 " +
            "AND ticket.ticket_status_id = 2", nativeQuery = true)
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
            "SET ticket.ticket_status_id = 4 " +
            "WHERE ticket.ticket_id = ?1", nativeQuery = true)
    void cancelBookedTicket(Integer ticketId);


    /**
     * author : HoangTQ
     * function : saveTicket()
     * @param movieTicketId : id of MovieTicket
     * @param seatId : id of a Seat
     * @param userId : id of a User
     * @param ticketStatusId : id of a TicketStatus
     * @param timeCreate : create Ticket time
     */
    @Modifying
    @Transactional
    @Query( value =  "INSERT INTO ticket(movie_ticket_id, seat_id, user_id,ticket_status_id,time_create) " +
                    "VALUES (?1, ?2, ?3, ?4, ?5) ",
            nativeQuery = true)
    void saveTicket(Integer movieTicketId, Integer seatId, Integer userId, Integer ticketStatusId, String timeCreate);

}
