package com.c1120g1.cinema.service.impl;

import com.c1120g1.cinema.dto.MemberTicketDTO;
import com.c1120g1.cinema.entity.Ticket;
import com.c1120g1.cinema.repository.TicketRepository;
import com.c1120g1.cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    /**
     * Method: create ticket
     * Author: HanTH
     * @param memberTicketDTO
     */
    @Override
    public void createTicket(MemberTicketDTO memberTicketDTO) {
        String createTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        memberTicketDTO.setCreateTime( createTime );
        ticketRepository.createTicket( memberTicketDTO.getMovieTicketId(), memberTicketDTO.getSeatId(), memberTicketDTO.getUserId(), memberTicketDTO.getCreateTime(), memberTicketDTO.getTicketStatusId() );
    }
}
