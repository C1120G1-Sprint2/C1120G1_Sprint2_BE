package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Seat;

import java.util.List;

public interface SeatService {

    List<Seat> findAllByRoomId(Integer roomId);
}
