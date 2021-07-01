package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {
    Page<Ticket> findAllTicketByUsername(Pageable pageable, String username);

    void deleteById(Integer id);

    Ticket findById(Integer ticketId);
}
