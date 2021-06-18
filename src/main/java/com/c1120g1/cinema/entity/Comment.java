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
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "content",columnDefinition = "varchar(50)")
    private String content;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "movie")
    private Movie movie;
}
