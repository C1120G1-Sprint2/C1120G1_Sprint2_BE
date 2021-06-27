package com.c1120g1.cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "status_room")
public class StatusRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_room_id")
    private Integer statusRoomId;

    @Column(name = "status_room_name", columnDefinition = "varchar(20)")
    private String statusRoomName;

    @OneToMany(mappedBy = "statusRoom")
    @JsonIgnore
    private Set<Room> roomSet;
}
