package com.c1120g1.cinema.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MemberTicketDTO {
    private Integer ticketId;
    private Integer movieTicketId;
    private Integer seatId;
    private Integer userId;
    private String createTime;
    private Integer ticketStatusId;
}