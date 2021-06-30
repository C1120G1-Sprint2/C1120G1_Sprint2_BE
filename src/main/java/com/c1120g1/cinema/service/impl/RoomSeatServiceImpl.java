package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.RoomSeat;
import com.c1120g1.cinema.repository.RoomSeatRepository;
import com.c1120g1.cinema.service.RoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomSeatServiceImpl implements RoomSeatService {

    @Autowired
    private RoomSeatRepository roomSeatRepository;

    @Override
    public List<RoomSeat> showAllSeatByRoomId(Integer roomId) {
        return roomSeatRepository.showAllSeatByRoomId(roomId);
    }

    @Override
    public void deleteSeat(Integer roomSeatId) {
        roomSeatRepository.deleteSeat(roomSeatId);
    }

    @Override
    public List<RoomSeat> getSeatTotal(Integer roomId) {
        return roomSeatRepository.getSeatTotal(roomId);
    }

    @Override
    public void creatSeat(Integer roomSeatId) {
        roomSeatRepository.creatSeat(roomSeatId);
    }

    @Override
    public RoomSeat findById(Integer id) {
        return roomSeatRepository.findById(id).orElse(null);
    }

    @Override
    public List<RoomSeat> showSeatDelete() {
        return roomSeatRepository.showSeatDelete();
    }
}
