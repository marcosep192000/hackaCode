package com.hackacode.marveland.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.hackacode.marveland.model.entity.PurchaseDetails;

import java.time.LocalDate;
import java.util.List;


public interface IPurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Long> {

    public List<PurchaseDetails> findByPurchaseDate(LocalDate date);
}