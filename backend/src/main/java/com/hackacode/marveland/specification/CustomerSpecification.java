package com.hackacode.marveland.specification;

import org.springframework.data.jpa.domain.Specification;

import com.hackacode.marveland.model.entity.Customer;

public class CustomerSpecification {

    public static Specification<Customer> hasFirstName(String firstName) {
        return (root, query, cb) -> cb.equal(root.get("firstName"), firstName);
    }

    public static Specification<Customer> hasLastName(String lastName) {
        return (root, query, cb) -> cb.equal(root.get("lastName"), lastName);
    }

    public static Specification<Customer> hasDni(Integer dni) {
        return (root, query, cb) -> cb.equal(root.get("dni"), dni);
    }

    public static Specification<Customer> hasEmail(String email) {
        return (root, query, cb) -> cb.equal(root.get("email"), email);
    }

    public static Specification<Customer> hasPhone(String phone) {
        return (root, query, cb) -> cb.equal(root.get("phone"), phone);
    }
}