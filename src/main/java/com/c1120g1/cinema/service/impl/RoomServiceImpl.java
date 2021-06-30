package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Room;
import com.c1120g1.cinema.entity.RoomSeat;
import com.c1120g1.cinema.repository.RoomRepository;
import com.c1120g1.cinema.repository.RoomSeatRepository;
import com.c1120g1.cinema.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomSeatRepository roomSeatRepository;

    @Override
    public List<Room> findAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public Page<Room> findAllRoom(Pageable pageable, String roomName) {
        return roomRepository.findAllByRoomName(roomName, pageable);
    }

    @Override
    public Room findRoomById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public void addRoom(Room room) {
        Room room1 = roomRepository.save(room);
//        roomSeatRepository.saveRoom(room1.getRoomId());
    }

    @Override
    public void editRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Integer roomId) {
        roomRepository.deleteAllByRoom(roomId);
    }

    @Override
    public void checkDup(Room room, Errors errors) {
        for (Room room1 : findAllRoom()) {
            if (room1.getRoomName().equals(room.getRoomName())) {
                errors.rejectValue("roomName", "checkDupRoomName");
            }
        }
    }

    @Override
    public List<Room> searchAllRoom(String roomName) {
        return roomRepository.searchAllRoom(roomName);
    }

    @Override
    public Page<Room> findAllByRoomName(String roomName, Pageable pageable) {
        return roomRepository.findAllByRoomName(roomName, pageable);
    }
}
