package com.hackacode.marveland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackacode.marveland.model.entity.PurchaseDetails;

public interface IPurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Long> {

}