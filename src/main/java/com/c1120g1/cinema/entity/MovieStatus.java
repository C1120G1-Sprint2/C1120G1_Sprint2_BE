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
@Table(name = "movie_status")
public class MovieStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_status_id")
    private Integer movieStatusId;

    @Column(name = "movie_status_name",columnDefinition = "varchar(50)")
    private String movieStatusName;

    @OneToMany(mappedBy = "movieStatus")
    @JsonManagedReference
    private Set<Movie> movieSet;
}
