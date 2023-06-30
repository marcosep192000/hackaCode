package com.hackacode.marveland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackacode.marveland.model.entity.Message;

public interface IMessageRepository extends JpaRepository<Message, Long> {

}
