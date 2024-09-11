package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public Employee addEmployee(@RequestBody Employee emp){
        return employeeService.saveEmployee(emp);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getById(id);
    }

    @GetMapping("/get")
    public List<Employee> getAllEmployees(){
        return employeeService.getListOfEmployees();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee emp, @PathVariable int id){
        return employeeService.updateEmployeeInformation(emp,id);
    }
}
