package com.c1120g1.cinema.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "movie_ticket_id", referencedColumnName = "movie_ticket_id")
    private MovieTicket movieTicket;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id")
    private Seat seat;

    @Column(name = "time_create",columnDefinition = "date")
    private String timeCreate;

    @ManyToOne
    @JoinColumn(name = "ticket_status_id", referencedColumnName = "ticket_status_id")
//    @JsonBackReference
    private TicketStatus ticketStatus;
}
