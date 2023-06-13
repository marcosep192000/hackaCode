package com.hackacode.marveland.repository;

import com.hackacode.marveland.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ITicketRepository extends JpaRepository<Ticket, Long> {

    //List<Ticket> findByDate(Date date);
}