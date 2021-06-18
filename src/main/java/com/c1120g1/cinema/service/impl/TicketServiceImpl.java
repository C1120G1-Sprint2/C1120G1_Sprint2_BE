package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.dto.TicketDTO;
import com.c1120g1.cinema.entity.Ticket;
import com.c1120g1.cinema.repository.TicketRepository;
import com.c1120g1.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    /**
     * author: QuangHL
     * method: Show list booked ticket
     */
    @Override
    public Page<Ticket> findAllByBookedTicket(Pageable pageable) {
        return ticketRepository.findAllByBookedTicket(pageable);
    }

    /**
     * author: QuangHL
     * method: Search by ticket id
     */
    @Override
    public Page<Ticket> searchByTicketId(Integer ticketId, Pageable pageable) {
        return ticketRepository.searchByTicketId(ticketId, pageable);
    }

    /**
     * author: QuangHL
     * method: Search by user id
     */
    @Override
    public Page<Ticket> searchByUserId(Integer userId, Pageable pageable) {
        return ticketRepository.searchByUserId(userId, pageable);
    }

    /**
     * author: QuangHL
     * method: Search by id card
     */
    @Override
    public Page<Ticket> searchByIdCard(String idCard, Pageable pageable) {
        return ticketRepository.searchByIdCard(idCard, pageable);
    }

    /**
     * author: QuangHL
     * method: Search by phone number
     */
    @Override
    public Page<Ticket> searchByPhone(String phone, Pageable pageable) {
        return ticketRepository.searchByPhone(phone, pageable);
    }

    /**
     * author: QuangHL
     * method: Find ticket by ticket id
     */
    @Override
    public Ticket findTicketByTicketId(Integer ticketId) {
        return ticketRepository.findTicketByTicketId(ticketId);
    }

    /**
     * author: QuangHL
     * method: Receive booked ticket
     */
    @Override
    public void receiveBookedTicket(Integer ticketId) {
        ticketRepository.receiveBookedTicket(ticketId);
    }

    /**
     * author: QuangHL
     * method: Cancel booked ticket
     */
    @Override
    public void cancelBookedTicket(Integer ticketId) {
        ticketRepository.cancelBookedTicket(ticketId);
    }
}
