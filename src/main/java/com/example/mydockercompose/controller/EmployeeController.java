package com.example.mydockercompose.controller;

import com.example.mydockercompose.entity.Employee;
import com.example.mydockercompose.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;


@Slf4j
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


    @PostMapping("/update")
    public Employee updateEmployee(@RequestParam("name") String name, @RequestParam String newName) {
        Employee employee = employeeService.findByName(name);
        employee.setName(newName);

        employeeService.createEmployee(employee);

        return employee;
    }


    @GetMapping("/getEmp/{name}")
    public Employee getEmployeeById(@PathVariable("name") String name) {
        return employeeService.findByName(name);

    }


    @GetMapping("/del/{name}")
    public String deleteEmployee(@PathVariable("name") String name) {
        log.info("START controller DEL");
        employeeService.deleteEmployee(name);
        log.info("END CONTROLLER DEL");
        return name;
    }


    @GetMapping("/mw/{name}")
    public String meow(@PathVariable("name") String name) {


        return name;
    }
}
