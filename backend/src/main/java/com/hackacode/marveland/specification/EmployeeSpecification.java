package com.hackacode.marveland.specification;

import org.springframework.data.jpa.domain.Specification;

import com.hackacode.marveland.model.entity.Employee;

public class EmployeeSpecification {

    public static Specification<Employee> hasFirstName(String firstName) {
        return (root, query, cb) -> cb.equal(root.get("firstName"), firstName);
    }

    public static Specification<Employee> hasLastName(String lastName) {
        return (root, query, cb) -> cb.equal(root.get("lastName"), lastName);
    }

    public static Specification<Employee> hasDni(Integer dni) {
        return (root, query, cb) -> cb.equal(root.get("dni"), dni);
    }

    public static Specification<Employee> hasEmail(String email) {
        return (root, query, cb) -> cb.equal(root.get("email"), email);
    }

    public static Specification<Employee> hasWorkingHours(String workingHours) {
        return (root, query, cb) -> cb.equal(root.get("workingHours"), workingHours);
    }
}
