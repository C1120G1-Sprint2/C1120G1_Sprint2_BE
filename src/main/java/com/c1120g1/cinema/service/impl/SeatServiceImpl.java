package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Seat;
import com.c1120g1.cinema.repository.SeatRepository;
import com.c1120g1.cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<Seat> findAllByRoomId(Integer roomId) {
        return seatRepository.findAllByRoomId(roomId);
    }
}
