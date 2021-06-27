package com.c1120g1.cinema.service;

import com.c1120g1.cinema.entity.Seat;

import java.util.List;

public interface SeatService {

    List<Seat> findAllSeat();
    Seat findSeatById(Integer id);
    void addSeat(Seat seat);
    void updateSeat(Integer seatType, Integer seatId);
    void deleteSeat(Integer id);
    Seat findSeatByColumn_ColumnIdAndRow_RowId(Integer column_columnId, Integer row_rowId);
}
