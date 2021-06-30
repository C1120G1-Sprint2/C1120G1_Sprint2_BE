package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.RoomSeat;

import java.util.List;

public interface RoomSeatService {

    List<RoomSeat> showAllSeatByRoomId(Integer roomId);

    void deleteSeat(Integer roomSeatId);

    List<RoomSeat> getSeatTotal(Integer roomId);

    void creatSeat(Integer roomSeatId);

    RoomSeat findById(Integer id);

    List<RoomSeat> showSeatDelete();
}
