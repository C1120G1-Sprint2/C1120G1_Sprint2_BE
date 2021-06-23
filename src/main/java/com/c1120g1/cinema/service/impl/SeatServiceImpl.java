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

    /**
     * Method: get all room seat by room id and row id
     * Author: HanTH
     * @param roomId
     * @return
     */
    @Override
    public List<Seat> showAllSeatByRoomId(Integer roomId) {
        return seatRepository.showAllSeatByRoomId( roomId );
    }

    /**
     * Method: update status seat
     * Author: HanTH
     *
     * @param seatId
     * @param seatStatusId
     */
    @Override
    public void updateStatusSeat(Integer seatId, Integer seatStatusId) {
        seatRepository.updateStatusSeat( seatId,seatStatusId );
    }
}
