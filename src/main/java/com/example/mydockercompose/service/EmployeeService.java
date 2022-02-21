package com.example.mydockercompose.service;

import com.example.mydockercompose.entity.Employee;
import com.example.mydockercompose.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public void createEmployee(Employee employee) {
        employeeRepo.save(employee);
    }


    public List<Employee> getAll() {

     return employeeRepo.findAll();
    }
}
