package com.hackacode.marveland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackacode.marveland.model.entity.Ticket;

public interface ITicketRepository extends JpaRepository<Ticket, Long> {

}