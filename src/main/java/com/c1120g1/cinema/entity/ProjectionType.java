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
@Table(name = "projection_type")
public class ProjectionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projection_type_id")
    private Integer projectTypeId;

    @Column(name = "projection_type_name")
    private String projectTypeName;

    @OneToMany(mappedBy = "projectionType")
    @JsonManagedReference
    private Set<MovieTicket> movieTicketSet;
}
