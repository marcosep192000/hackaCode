package com.hackacode.marveland.repository;

import com.hackacode.marveland.model.entity.PurchaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IPurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Long> {

    public List<PurchaseDetails> findByDate(Date date);
}