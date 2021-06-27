package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.RoomSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomSeatRepository extends JpaRepository<RoomSeat,Integer> {

    @Query(value = "select * from cinema_db.room_seat where room_id = ?1",nativeQuery = true)
    List<RoomSeat> showAllSeatByRoomId(Integer roomId);

}
