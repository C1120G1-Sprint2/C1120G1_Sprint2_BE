package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Integer> {
    /**
     * Method: get all  seat by room id and row id
     * Author: HanTH
     * @param roomId
     * @return
     */
    @Query(value = "SELECT * FROM cinema_db.seat s \n" +
            "JOIN cinema_db.room_seat rs ON s.seat_id = rs.seat_id WHERE rs.room_id = ?1",nativeQuery = true)
    List<Seat> showAllSeatByRoomId(Integer roomId);
}
