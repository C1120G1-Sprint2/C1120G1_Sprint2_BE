package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Integer> {

    @Query( value = "select * from seat " +
                    "inner join room_seat on room_seat.seat_id = seat.seat_id " +
                    "where room_seat.room_id = ?1 ",
            nativeQuery = true)
    List<Seat> findAllByRoomId(Integer roomId);
}
