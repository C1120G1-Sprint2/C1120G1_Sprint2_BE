
package com.c1120g1.cinema.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JoinColumn(name = "seat_status")
    private SeatStatus seatStatus;


    @ManyToOne
    @JoinColumn(name = "row_id")
    private RowSeat row;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "column_id")
    private ColumnSeat column;

    @ManyToOne
    @JoinColumn(name = "seat_type_id")
    private SeatType seatType;

    @OneToMany(mappedBy = "seat")
    @JsonIgnore
    private Set<Ticket> ticketSet;

}
