package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    public Employee getById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new RuntimeException("Employee not found with id: " + id);
    }

    public List<Employee> getListOfEmployees() {
        return employeeRepository.findAll();
    }

    public String deleteEmployee(int id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee information deleted successfully!";
        }
        return "No such employee in the database";
    }

    public Employee updateEmployeeInformation(Employee emp, int id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()){
            Employee originalEmployee = employee.get();

            if (Objects.nonNull(emp.getFullName()) && !"".equalsIgnoreCase(emp.getFullName())) {
                originalEmployee.setFullName(emp.getFullName());
            }
            if (emp.getEmpSalary() != 0) {
                originalEmployee.setEmpSalary(emp.getEmpSalary());
            }
            if (Objects.nonNull(emp.getLocation()) && !"".equalsIgnoreCase(emp.getLocation())) {
                originalEmployee.setLocation(emp.getLocation());
            }
            return employeeRepository.save(originalEmployee);
        }
        else {
            throw new RuntimeException("No such employee is present");
        }
    }
}
