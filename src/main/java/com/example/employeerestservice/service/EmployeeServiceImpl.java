package com.example.employeerestservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeerestservice.dao.EmployeeRepository;
import com.example.employeerestservice.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	//private EmployeeDAO employeeDAO;
	
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		
		employeeRepository = theEmployeeRepository;
	}
	
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		return employeeRepository.findAll();
		
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub

//		return employeeRepository.findById(theId);
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			
			theEmployee = result.get();
		}else {
			
			throw new RuntimeException("Did not find employee id - "+theId);
		}
		
		return theEmployee;
	
	}
	
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		
		return employeeRepository.save(theEmployee);
	
	}

	@Transactional
	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
		employeeRepository.deleteById(theId);
		
	}
	
	

}
