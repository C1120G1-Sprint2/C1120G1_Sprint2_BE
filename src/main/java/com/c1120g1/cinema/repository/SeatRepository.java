package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    /**
     * Method: get all  seat by room id and row id
     * Author: HanTH
     *
     * @param roomId
     * @return
     */
    @Query(value = "SELECT * FROM cinema_db.seat s \n" +
            "JOIN cinema_db.room_seat rs ON s.seat_id = rs.seat_id WHERE rs.room_id = ?1", nativeQuery = true)
    List<Seat> showAllSeatByRoomId(Integer roomId);

    /**
     * Method: update status seat
     * Author: HanTH
     *
     * @param seatId
     * @param seatStatusId
     */
    @Transactional
    @Modifying
    @Query(value = "update cinema_db.seat set seat_status = ?2 where seat_id = ?1", nativeQuery = true)
    void updateStatusSeat(Integer seatId, Integer seatStatusId);
}
