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
@Table(name = "transaction_history")

public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "transaction_date", columnDefinition = "date")
    private String transactionDate;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "username", columnDefinition = "varchar(50)")
    private Account account;

    @Column(name = "description", columnDefinition = "varchar(50)")
    private String description;

    @Column(name = "status", columnDefinition = "bit")
    private boolean status;
}
