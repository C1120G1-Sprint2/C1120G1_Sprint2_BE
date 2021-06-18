package com.c1120g1.cinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "room_name",columnDefinition = "varchar(50)")
    private String roomName;

    @ManyToOne
    @JoinColumn(name = "status_room_id", referencedColumnName = "status_room_id")
    private StatusRoom statusRoom;

}
