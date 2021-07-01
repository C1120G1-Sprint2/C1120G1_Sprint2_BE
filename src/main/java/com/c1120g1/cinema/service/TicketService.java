package com.c1120g1.cinema.service;

import com.c1120g1.cinema.dto.MemberTicketDTO;
import com.c1120g1.cinema.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {

    List<Ticket> findAll();

    /**
     * author: QuangHL
     * method: Show list booked ticket
     */
    List<Ticket> findAllByBookedTicket(int index);

    /**
     * author: QuangHL
     * method: Show list booked ticket no page
     */
    List<Ticket> findAllByBookedTicketNoPage();

    /**
     * author: QuangHL
     * method: Find Ticket by ID
     */

    Ticket findById(Integer ticketId);

    /**
     * author: QuangHL
     * method: Search by ticket id
     */
    Page<Ticket> searchByTicketId(Integer ticketId, Pageable pageable);

    /**
     * author: QuangHL
     * method: Search by user id
     */
    Page<Ticket> searchByUserId(Integer userId, Pageable pageable);

    /**
     * author: QuangHL
     * method: Search by id card
     */
    Page<Ticket> searchByIdCard(String idCard, Pageable pageable);

    /**
     * author: QuangHL
     * method: Search by name customer
     */
    Page<Ticket> searchByName(String name, Pageable pageable);

    /**
     * author: QuangHL
     * method: Search by phone number
     */
    Page<Ticket> searchByPhone(String phone, Pageable pageable);

    /**
     * author: QuangHL
     * method: Print ticket by ticket id
     */
    Ticket findTicketByTicketId(Integer ticketId);

    /**
     * author: QuangHL
     * method: Receive booked ticket
     */
    void receiveBookedTicket(Integer ticketId);

    /**
     * author: QuangHL
     * method: Cancel booked ticket
     */
    void cancelBookedTicket(Integer ticketId);

    /**
     * author : HoangTQ
     * @param memberTicketDTO : a MemberTicketDTO object
     */
    void saveTicket(MemberTicketDTO memberTicketDTO);

    void saveTicketDTO(Integer movieTicketId, Integer userId, Integer seatId);

    //HanTH
    void createTicket(MemberTicketDTO memberTicketDTO);
    //HanTH


    Page<Ticket> findAllTicketByUsername(Pageable pageable, String username);

    void deleteById(Integer id);


}
