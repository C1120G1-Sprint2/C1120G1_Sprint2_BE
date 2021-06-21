package com.c1120g1.cinema.repository;

import com.c1120g1.cinema.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Integer> {
    Seat findSeatByColumn_ColumnIdAndRow_RowId(Integer column_columnId, Integer row_rowId);
}
