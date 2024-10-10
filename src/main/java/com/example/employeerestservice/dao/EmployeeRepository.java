package com.example.employeerestservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeerestservice.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {

}
