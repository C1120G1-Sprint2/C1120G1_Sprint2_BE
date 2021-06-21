package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.RoomSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomSeatRepository extends JpaRepository<RoomSeat,Integer> {

    List<RoomSeat> findAllByRoom_RoomId(Integer room_roomId);
}
