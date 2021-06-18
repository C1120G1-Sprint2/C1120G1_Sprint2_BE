
package com.c1120g1.cinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notify_id")
    private Integer notifyId;

    @Column(name = "notify_content", columnDefinition = "varchar(255)")
    private String notifyContent;

    @Column(name = "notify_date", columnDefinition = "datetime")
    private String notifyDate;

    @ManyToOne
    @JoinColumn(name = "username", columnDefinition = "varchar(50)", referencedColumnName = "username")
    private Account account;
}

