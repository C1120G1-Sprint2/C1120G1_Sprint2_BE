package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Ticket;
import com.c1120g1.cinema.repository.TicketRepository;
import com.c1120g1.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;


    @Override
    public Page<Ticket> findAllTicketByUsername(Pageable pageable, String username) {
        return ticketRepository.findTicketOfUser(pageable,username);
    }

    @Override
    public void deleteById(Integer id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Ticket findById(Integer ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }
}
