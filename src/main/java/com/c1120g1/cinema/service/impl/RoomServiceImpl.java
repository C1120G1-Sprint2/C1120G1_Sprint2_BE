package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Room;
import com.c1120g1.cinema.repository.RoomRepository;
import com.c1120g1.cinema.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}
