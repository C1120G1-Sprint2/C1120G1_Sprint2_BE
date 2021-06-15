package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.TicketStatusRepository;
import com.c1120g1.cinema.service.TicketStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketStatusServiceImpl implements TicketStatusService {

    @Autowired
    private TicketStatusRepository ticketStatusRepository;
}
