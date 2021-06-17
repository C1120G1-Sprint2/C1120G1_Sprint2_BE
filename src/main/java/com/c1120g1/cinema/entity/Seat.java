package com.c1120g1.cinema.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "`seat`",
        uniqueConstraints = {
                @UniqueConstraint(name = "SEAT_UK", columnNames = "seat_id")
        })
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id",columnDefinition = "int")
    private Integer seatId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "seat_status")
    private SeatStatus seatStatus;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "row_id")
    private RowSeat row;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "column_id")
    private ColumnSeat column;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "seat_type")
    private SeatType seatType;

    @OneToMany(mappedBy = "seat")
    @JsonManagedReference
    private Set<Ticket> ticketSet;
}
