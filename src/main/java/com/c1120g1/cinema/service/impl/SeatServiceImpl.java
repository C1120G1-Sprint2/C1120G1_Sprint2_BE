package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.Seat;
import com.c1120g1.cinema.repository.SeatRepository;
import com.c1120g1.cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<Seat> findAllSeat() {
        return seatRepository.findAll();
    }

    @Override
    public Seat findSeatById(Integer id) {
        return seatRepository.findById(id).orElse(null);
    }

    @Override
    public void addSeat(Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    public void updateSeat(Seat seat) {
        seatRepository.save(seat);
    }


    @Override
    public void deleteSeat(Integer id) {
        seatRepository.deleteById(id);
    }

    @Override
    public Seat findSeatByColumn_ColumnIdAndRow_RowId(Integer column_columnId, Integer row_rowId) {
        return seatRepository.findSeatByColumn_ColumnIdAndRow_RowId(column_columnId, row_rowId);
    }


}
