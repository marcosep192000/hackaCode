package com.hackacode.marveland.repository;

import com.hackacode.marveland.model.entity.PurchaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Long> {
}