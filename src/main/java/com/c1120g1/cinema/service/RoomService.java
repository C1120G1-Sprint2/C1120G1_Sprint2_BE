package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoomService {

    List<Room> findAllRoom();

    Page<Room> findAllRoom(Pageable pageable);

    Room findRoomById(Integer id);

    void addRoom(Room room);

    void editRoom(Room room);

    void deleteRoom(Integer roomId);
}
