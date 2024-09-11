package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "EmployeeDetails")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee ID")
    @JsonProperty("empID")
    private int employeeID;

    @Column(name = "Employee Name")
    @JsonProperty("empName")
    private String fullName;

    @Column(name = "Employee location")
    @JsonProperty("empLocation")
    private String location;

    @Column(name = "Employee Salary")
    @JsonProperty("empSalary")
    private double empSalary;

    public Employee() {
    }

    public Employee(int employeeID, String fullName, String location, double empSalary) {
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.location = location;
        this.empSalary = empSalary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }
}
