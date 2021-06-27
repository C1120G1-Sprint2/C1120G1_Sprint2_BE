package com.c1120g1.cinema.entity;

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
@Table(name = "seat_status")
public class SeatStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_status_id")
    private Integer seatStatusId;

    @Column(name = "status_name", columnDefinition = "varchar(50)")
    private String statusName;

    @OneToMany(mappedBy = "seatStatus")
    @JsonManagedReference
    private Set<Seat> seatSet;
}
