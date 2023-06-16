package com.hackacode.marveland.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import com.hackacode.marveland.model.entity.PurchaseDetails;
import com.hackacode.marveland.util.enums.PaymentMethod;

public class PurchaseDetailsSpecification {

    public static Specification<PurchaseDetails> hasDetails(String details) {
        return (root, query, cb) -> cb.equal(root.get("details"), details);
    }

    public static Specification<PurchaseDetails> hasPurchaseDate(LocalDate purchaseDate) {
        return (root, query, cb) -> cb.equal(root.get("purchaseDate"), purchaseDate);
    }

    public static Specification<PurchaseDetails> hasPaymentMethod(PaymentMethod paymentMethod) {
        return (root, query, cb) -> cb.equal(root.get("paymentMethod"), paymentMethod);
    }
}
