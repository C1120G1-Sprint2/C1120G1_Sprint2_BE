package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.repository.RoomSeatRepository;
import com.c1120g1.cinema.service.RoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomSeatServiceImpl implements RoomSeatService {

    @Autowired
    private RoomSeatRepository roomSeatRepository;

}
