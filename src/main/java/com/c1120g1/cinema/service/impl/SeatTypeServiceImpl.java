package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.SeatTypeRepository;
import com.c1120g1.cinema.service.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatTypeServiceImpl implements SeatTypeService {

    @Autowired
    private SeatTypeRepository seatTypeRepository;
}
