package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.entity.RoomSeat;
import com.c1120g1.cinema.repository.RoomSeatRepository;
import com.c1120g1.cinema.service.RoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomSeatServiceImpl implements RoomSeatService {

    @Autowired
    private RoomSeatRepository roomSeatRepository;

    @Override
    public List<RoomSeat> findAllByRoomId(Integer roomId) {
        return roomSeatRepository.findAllByRoomId(roomId);
    }

    @Override
    public void updateRoomSeatStatus(Integer seatId, Integer roomId) {
        roomSeatRepository.updateRoomSeatStatus( seatId, roomId );
    }

    /**
     * Method: get all room seat by room id and row id
     * Author: HanTH
     * @param roomId
     * @return
     */
    @Override
    public List<RoomSeat> showAllSeatByRoomId(Integer roomId) {
        return roomSeatRepository.showAllRoomSeatByRoomId( roomId );
    }

    /**
     * Method: update status seat
     * Author: HanTH
     *
     * @param seatId
     * @param seatStatusId
     */
    @Override
    public void updateStatusSeat(Integer roomId, Integer seatId, Integer seatStatusId) {
        roomSeatRepository.updateStatusSeat(roomId, seatId,seatStatusId );
    }
}
