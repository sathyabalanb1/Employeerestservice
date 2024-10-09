package com.example.employeerestservice.dao;

import java.util.List;

import com.example.employeerestservice.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);

}
