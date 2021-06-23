package com.c1120g1.cinema.service;

import com.c1120g1.cinema.dto.MemberTicketDTO;
import com.c1120g1.cinema.entity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> findAll();
    //HanTH
    void createTicket(MemberTicketDTO memberTicketDTO);
    //HanTH
}
