package com.c1120g1.cinema.dto;

public class MemberTicketDTO {

    private Integer movieTicketId;
    private Integer userId;
    private Integer seatId;

    public MemberTicketDTO() {
    }

    public MemberTicketDTO(Integer movieTicketId, Integer userId, Integer seatId) {
        this.movieTicketId = movieTicketId;
        this.userId = userId;
        this.seatId = seatId;
    }

    public Integer getMovieTicketId() {
        return movieTicketId;
    }

    public void setMovieTicketId(Integer movieTicketId) {
        this.movieTicketId = movieTicketId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }
}
