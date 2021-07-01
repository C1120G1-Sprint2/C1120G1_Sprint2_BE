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

    @Query( value = "select * from room_seat " +
                    "where room_seat.room_id = 1 and room_seat.seat_status_id in (1, 2) ",
            nativeQuery = true)
    List<RoomSeat> findAllByRoomId(Integer roomId);

    @Modifying
    @Transactional
    @Query(value =  "update room_seat " +
                    "set seat_status_id = 2 " +
                    "where seat_id = ?1 and room_id = ?2",
            nativeQuery = true)
    void updateRoomSeatStatus(Integer seatId, Integer roomId);

    /**
     * Method: get all  seat by room id and row id
     * Author: HanTH
     *
     * @param roomId
     * @return
     */
    @Query(value = "SELECT * FROM cinema_db.room_seat WHERE room_id = ?1 AND (seat_status_id = 1 or seat_status_id = 2)", nativeQuery = true)
    List<RoomSeat> showAllRoomSeatByRoomId(Integer roomId);

    /**
     * Method: update status seat
     * Author: HanTH
     *
     * @param seatId
     * @param seatStatusId
     */
    @Transactional
    @Modifying
    @Query(value = "update cinema_db.room_seat set seat_status_id = ?3 where (room_id = ?1 and seat_id = ?2)", nativeQuery = true)
    void updateStatusSeat(Integer roomId, Integer seatId, Integer seatStatusId);


}
