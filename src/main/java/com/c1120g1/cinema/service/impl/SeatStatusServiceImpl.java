package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.SeatStatusRepository;
import com.c1120g1.cinema.service.SeatStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatStatusServiceImpl implements SeatStatusService {

    @Autowired
    private SeatStatusRepository seatStatusRepository;
}
