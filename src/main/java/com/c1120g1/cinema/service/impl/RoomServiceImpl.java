package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Room;
import com.c1120g1.cinema.repository.RoomRepository;
import com.c1120g1.cinema.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> findAllRoom() {
        return roomRepository.showAllRoom();
    }

    @Override
    public Page<Room> findAllRoom(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }

    @Override
    public Room findRoomById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void editRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Integer roomId) {
        roomRepository.deleteAllByRoom(roomId);
    }
}
