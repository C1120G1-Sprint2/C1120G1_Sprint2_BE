package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Ticket;
import com.c1120g1.cinema.entity.User;

import java.util.List;

public interface TicketService {
    List<Ticket> findAllTicketByUsername(String username);

    void deleteById(Integer id);

    Ticket findById(Integer ticketId);
}
