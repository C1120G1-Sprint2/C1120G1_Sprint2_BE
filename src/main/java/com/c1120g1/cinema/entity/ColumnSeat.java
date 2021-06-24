
package com.c1120g1.cinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String columnName;

}
