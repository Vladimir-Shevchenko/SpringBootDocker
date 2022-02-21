package com.example.mydockercompose.controller;

import com.example.mydockercompose.entity.Employee;
import com.example.mydockercompose.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }


    @PostMapping("/new")
    public Employee createEmployee() {
        Employee employee = new Employee();
        employee.setName(RandomString.make(16));
        employee.setSurname(RandomString.make(16));
        employee.setDepartment(RandomString.make(16));
        employee.setSalary(new Random().nextInt(1000));

        employeeService.createEmployee(employee);

        return employee;
    }
    
}
