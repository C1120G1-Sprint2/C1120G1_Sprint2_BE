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
@Table(name = "movie_ticket")
public class MovieTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_ticket_id")
    private Integer movieTicketId;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;

    @ManyToOne
<<<<<<< HEAD
    @JsonBackReference
=======
>>>>>>> 5b07947d6c599ccedd717a83c5d3165bfda7a07e
    @JoinColumn(name = "show_time_id", referencedColumnName = "show_time_id")
    private ShowTime showTime;

    @Column(name = "show_date",columnDefinition = "date")
    private String showDate;

    @Column(name = "ticket_price", columnDefinition = "varchar(50)")
    private String ticketPrice;

    @ManyToOne
<<<<<<< HEAD
    @JsonBackReference
=======
>>>>>>> 5b07947d6c599ccedd717a83c5d3165bfda7a07e
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private Room room;

    @ManyToOne
<<<<<<< HEAD
    @JsonBackReference
=======
>>>>>>> 5b07947d6c599ccedd717a83c5d3165bfda7a07e
    @JoinColumn(name = "projection_type_id", referencedColumnName = "projection_type_id")
    private ProjectionType projectionType;

    @OneToMany(mappedBy = "movieTicket")
    @JsonIgnore
    private Set<Ticket> ticketSet;
}
