package com.c1120g1.cinema.controller;


import com.c1120g1.cinema.entity.Room;
import com.c1120g1.cinema.entity.RoomSeat;
import com.c1120g1.cinema.entity.Seat;
import com.c1120g1.cinema.service.RoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.c1120g1.cinema.entity.RoomSeat;
import com.c1120g1.cinema.service.RoomSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/roomSeat")
public class RoomSeatController {

    @Autowired
    private RoomSeatService roomSeatService;


    @GetMapping(value = "/roomSeat/{roomId}")
    public ResponseEntity<List<RoomSeat>> getListRoom(@PathVariable Integer roomId) {
        List<RoomSeat> roomList = roomSeatService.showAllSeatByRoomId(roomId);
        if (roomList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roomList, HttpStatus.OK);
    }


    /**
     * Method: delete seat
     * Author: TuanLHM
     *
     * @return
     */

    @GetMapping(value = "/seat/delete-seat/{id}")
    public ResponseEntity<RoomSeat> deleteRoom(@PathVariable("id") Integer id) {

        RoomSeat roomSeat = roomSeatService.findById(id);
        if (roomSeat.getRoomSeatId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            roomSeatService.deleteSeat(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /**
     * HoangTQ
     * getAllSeat()
     *
     * @param roomId : id of Room
     * @return listRoomSeat
     */
    @GetMapping("/getAllSeat/{roomId}")
    public ResponseEntity<List<RoomSeat>> getAllSeat(@PathVariable(name =  "roomId") Integer roomId) {
        List<RoomSeat> listRoomSeat = roomSeatService.findAllByRoomId( roomId );
        if (listRoomSeat.isEmpty()) {
            return new ResponseEntity<>( HttpStatus.NO_CONTENT );
        }
        return new ResponseEntity<>( listRoomSeat, HttpStatus.OK );

    }

    /**
     * Method: get all seat by room id
     * Author: HanTH
     *
     * @param roomId
     * @return
     */
    @GetMapping("/saleTicket/listRoomSeat/{roomId}")
    public ResponseEntity<List<RoomSeat>> showAllSeatByRoomId(@PathVariable Integer roomId) {
        try {
            List<RoomSeat> seatList = roomSeatService.showAllSeatByRoomId( roomId );
            if (seatList.isEmpty()) {
                return new ResponseEntity<>( HttpStatus.NO_CONTENT );
            } else {
                return new ResponseEntity<>( seatList, HttpStatus.OK );
            }
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
    }
}
