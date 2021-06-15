package com.c1120g1.cinema.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "movie_room",
        uniqueConstraints = {
                @UniqueConstraint(name = "MOVIE_ROOM_UK", columnNames = {"movie_id","room_id"})
        })
public class MovieRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_room_id")
    private Integer movieRoomId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
