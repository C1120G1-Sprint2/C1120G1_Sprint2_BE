package com.c1120g1.cinema.controller;

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

    /**
     * HoangTQ
     * getAllSeat()
     *
     * @param roomId : id of Room
     * @return listRoomSeat
     */
    @GetMapping("/getAllSeat/{roomId}")
    public ResponseEntity<List<RoomSeat>> getAllSeat(@PathVariable(name = "roomId") Integer roomId) {
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
    @GetMapping("api/employee/saleTicket/listRoomSeat/{roomId}")
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
