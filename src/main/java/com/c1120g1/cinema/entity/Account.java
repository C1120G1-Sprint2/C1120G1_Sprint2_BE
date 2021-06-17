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
@Table(name = "account",
        uniqueConstraints = {
                @UniqueConstraint(name = "ACC_UK", columnNames = "username")
        })
public class Account {

    @Id
    @Column(name = "username", columnDefinition = "VARCHAR(50) UNIQUE NOT NULL")
    private String username;

    @Column(name = "`password`", columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "register_date", columnDefinition = "DATE")
    private String registerDate;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "status")
    private AccountStatus accountStatus;

    @OneToOne(mappedBy = "account")
    @JsonManagedReference
    private User user;

    @Column(name = "point", columnDefinition = "varchar(50)")
    private String point;

    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    private Set<Notification> notificationSet;

    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    private Set<TransactionHistory> transactionHistorySet;
}