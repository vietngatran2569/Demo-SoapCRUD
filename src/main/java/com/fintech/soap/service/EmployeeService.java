package com.fintech.soap.service;

import com.fintech.soap.entity.Employee;
import com.fintech.soap.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>(employeeRepository.findAll());
        return list;
    }

    public synchronized boolean addEmployee(Employee employee) {
        List<Employee> list = employeeRepository.findByFirstnameAndLastname(employee.getFirstname(),employee.getLastname());
        if (list.size() > 0) {
            return false;
        } else {
            employeeRepository.save(employee);
            return true;
        }
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }
}
