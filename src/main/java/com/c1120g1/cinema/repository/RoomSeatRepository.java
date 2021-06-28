package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.RoomSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoomSeatRepository extends JpaRepository<RoomSeat,Integer> {

    @Query(value = "select * from cinema_db.room_seat where room_id = ?1 and (seat_status_id = 1 or seat_status_id = 2)",nativeQuery = true)
    List<RoomSeat> showAllSeatByRoomId(Integer roomId);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE cinema_db.room_seat SET seat_status_id = 3 WHERE room_seat_id = ?1",nativeQuery = true)
    void deleteSeat(Integer roomSeatId);
}
