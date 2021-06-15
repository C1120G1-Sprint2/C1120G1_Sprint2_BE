package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.MovieTicketRepository;
import com.c1120g1.cinema.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieTicketServiceImpl implements MovieTicketService {

    @Autowired
    private MovieTicketRepository movieTicketRepository;
}
