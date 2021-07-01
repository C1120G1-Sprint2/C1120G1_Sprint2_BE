package com.c1120g1.cinema.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
//    @JsonBackReference
    @JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Account account;

    @Column(name = "birthday", columnDefinition = "date")
    private String birthday;

    @Column(name = "gender", columnDefinition = "int")
    private Integer gender;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "phone", columnDefinition = "VARCHAR(20)")
    private String phone;

    @Column(name = "id_card", columnDefinition = "VARCHAR(20)")
    private String idCard;

    @Column(name = "avatar_url", columnDefinition = "VARCHAR(255)")
    private String avatarUrl;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "ward_id", referencedColumnName = "ward_id")
    private Ward ward;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference
    @JsonIgnore
    private Set<Ticket> ticketSet;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference
    @JsonIgnore
    private Set<Comment> commentSet;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference
    @JsonIgnore
    private Set<Rating> ratingSet;
}
