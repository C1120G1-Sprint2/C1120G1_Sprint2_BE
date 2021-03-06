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
@Table(name = "category",
        uniqueConstraints = {
                @UniqueConstraint(name = "CATEGORY_UK", columnNames = "category_id")
        })
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;

}
