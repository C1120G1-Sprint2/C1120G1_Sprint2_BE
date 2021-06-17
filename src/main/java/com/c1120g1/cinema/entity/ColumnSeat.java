package com.c1120g1.cinema.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "`column`")
public class ColumnSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "column_id")
    private Integer columnId;

    @Column(name = "column_name", columnDefinition = "varchar(50)")
    private String columnNameId;

    @OneToMany(mappedBy = "column")
    @JsonManagedReference
    private Set<Seat> seatSet;
}
