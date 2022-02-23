package com.example.mydockercompose.service;

import com.example.mydockercompose.entity.Employee;
import com.example.mydockercompose.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Transactional
    public void createEmployee(Employee employee) {
        employeeRepo.save(employee);
    }


    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }


    public Employee findByName(String name) {
        return employeeRepo.findByName(name);
    }


    @Transactional
    public void deleteEmployee(String name) {
        Employee employee = employeeRepo.findByName(name);
        employeeRepo.delete(employee);
    }
}
