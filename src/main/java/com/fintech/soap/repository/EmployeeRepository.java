package com.fintech.soap.repository;

import com.fintech.soap.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeId(Long employeeId);
    List<Employee> findByFirstnameAndLastname(String firstname, String lastname);
}
