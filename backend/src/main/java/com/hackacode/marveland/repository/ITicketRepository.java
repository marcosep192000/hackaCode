package com.hackacode.marveland.repository;

import com.hackacode.marveland.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketRepository extends JpaRepository<Ticket, Long> {
}