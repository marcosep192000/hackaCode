package com.hackacode.marveland.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackacode.marveland.model.entity.PurchaseDetails;

public interface IPurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Long> {

    public List<PurchaseDetails> findByPurchaseDate(LocalDate date);
}