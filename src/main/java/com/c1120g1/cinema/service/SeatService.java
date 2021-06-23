package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Seat;

import java.util.List;

public interface SeatService {
    //    HanTH
    List<Seat> showAllSeatByRoomId(Integer roomId);

    void updateStatusSeat(Integer seatId, Integer seatStatusId);
//    HanTH
}
