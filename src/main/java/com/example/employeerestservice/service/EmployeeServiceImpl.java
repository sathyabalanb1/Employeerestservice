package com.example.employeerestservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeerestservice.dao.EmployeeDAO;
import com.example.employeerestservice.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theemployeeDAO) {
		
		employeeDAO = theemployeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		return employeeDAO.findAll();
		
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub

		return employeeDAO.findById(theId);
	
	}
	
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		
		return employeeDAO.save(theEmployee);
	
	}

	@Transactional
	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
		employeeDAO.deleteById(theId);
		
	}
	
	

}
