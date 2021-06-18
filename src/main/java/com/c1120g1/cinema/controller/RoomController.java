package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.entity.Room;
import com.c1120g1.cinema.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/admin")
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * Method: get all room
     * Author: TuanLHM
     *
     * @return
     */

    @GetMapping("/room")
    public ResponseEntity<List<Room>> getListRoom() {
        List<Room> roomList = roomService.findAllRoom();
        if (roomList.isEmpty()) {
            return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Room>>(roomList, HttpStatus.OK);
    }

    /**
     * Method: get room by id
     * Author: TuanLHM
     *
     * @return
     */

    @GetMapping("/room/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable int id) {
        return new ResponseEntity<>(this.roomService.findRoomById(id), HttpStatus.OK);
    }

    /**
     * Method: create room
     * Author: TuanLHM
     *
     * @return
     */

    @PostMapping(value = "/room/create-room", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRoom(@RequestBody Room room, BindingResult bindingResult, UriComponentsBuilder ucBuilder) {
        roomService.addRoom(room);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/room/{id}").buildAndExpand(room.getRoomId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * Method: edit room
     * Author: TuanLHM
     *
     * @return
     */

    @PutMapping("/room/edit-room/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Integer id, @RequestBody Room room) {

        Room room1 = roomService.findRoomById(id);

        if (room1 == null || id == null) {
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        } else {

            room1.setRoomName(room.getRoomName());
            room1.setRoomId(id);

            roomService.editRoom(room1);
            return new ResponseEntity<Room>(room1, HttpStatus.OK);
        }
    }

    /**
     * Method: delete room
     * Author: TuanLHM
     *
     * @return
     */

    @GetMapping(value = "/room/delete-room/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable("id") Integer id) {

        Room room = roomService.findRoomById(id);
        if (room.getRoomId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            roomService.deleteRoom(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
