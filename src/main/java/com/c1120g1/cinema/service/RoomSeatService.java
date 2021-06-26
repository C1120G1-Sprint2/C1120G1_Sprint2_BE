package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.RoomSeat;
import com.c1120g1.cinema.entity.Seat;

import java.util.List;

public interface RoomSeatService {
    //    HanTH
    List<RoomSeat> showAllSeatByRoomId(Integer roomId);

    void updateStatusSeat(Integer roomId, Integer seatId, Integer seatStatusId);
//    HanTH
}
