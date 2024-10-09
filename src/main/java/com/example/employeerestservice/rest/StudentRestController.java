package com.example.employeerestservice.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeerestservice.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	/*
	@PostConstruct is called only once: The method annotated with @PostConstruct (in this case, loadData()) is called only once after the bean is initialized and its dependencies are injected. This happens when the Spring application starts, or when the StudentRestController bean is first created by the Spring container.

	When the Spring application starts, the loadData() method will initialize the theStudents list.
	Each time you call the getStudents() method, the same theStudents list (initialized in loadData()) will be returned.
	The list will not be recreated for each request.
	*/
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;

	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {	
		
		if( (studentId >= theStudents.size()) || (studentId < 0)) {
			
			throw new StudentNotFoundException("Student ID Not Found - "+studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	/*
	The ResponseEntity is really just a wrapper

	for the HTTP response object.

	It gives you fine-grained control

	over specifying the actual status code,

	the actual HTTP headers, and also the body.
	
	*/
	
	/*
	So any StudentNotFoundExceptions

	that are thrown this actual handler method will catch it

	and then work on it accordingly.
	
	*/
	
	/*
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	//	return null;
	}
	*/

}
