package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.RoomSeat;

import java.util.List;

public interface RoomSeatService {




    void deleteSeat(Integer roomSeatId);

    RoomSeat findById(Integer id);

    List<RoomSeat> findAllByRoomId(Integer roomId);

    void updateRoomSeatStatus(Integer seatId, Integer roomId);

    //    HanTH
    List<RoomSeat> showAllSeatByRoomId(Integer roomId);

    void updateStatusSeat(Integer roomId, Integer seatId, Integer seatStatusId);
//    HanTH

}
