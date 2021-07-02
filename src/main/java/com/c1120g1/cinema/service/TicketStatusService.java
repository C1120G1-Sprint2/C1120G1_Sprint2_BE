package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.TicketStatus;

import java.util.List;

public interface TicketStatusService {

    List<TicketStatus> findAll();

    TicketStatus findById(Integer ticketStatusId);
}
