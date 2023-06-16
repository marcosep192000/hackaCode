package com.hackacode.marveland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

import com.hackacode.marveland.model.entity.PurchaseDetails;

public interface IPurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Long> {

    public List<PurchaseDetails> findByDate(Date date);

}