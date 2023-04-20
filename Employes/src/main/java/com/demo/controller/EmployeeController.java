package com.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.entity.exception.ResourceNotFoundException;
import com.demo.entity.exception.Response;
import com.demo.service.EmployeeService;
import com.demo.serviceimple.Message;

@RestController
@RequestMapping("Employee-service/v1")
public class EmployeeController 
{

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	Message message;

	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		Employee employee2=message.saveEmployee(employee);
		return new ResponseEntity<>(employee2, HttpStatus.CREATED);
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	@GetMapping("asc")
	public List<Employee> findAllByOrderByIdAsc()
	{
		return employeeService.findAllByOrderByIdAsc();
	}
	
	@GetMapping("desc")
	public List<Employee> findAllByOrderByIdDesc()
	{
		return employeeService.getAllEmployeeByOrderByIdDesc();
	}

	@GetMapping("update/{id}")
	public Employee updateEmployeeById(@RequestBody Employee employee, @PathVariable int id)
	{
		return employeeService.updateById(employee, id);
	}
	
	@DeleteMapping("delete/{id}")
	public Response delteById(@PathVariable int id) 
	{
		return employeeService.deleteById(id);
	}
	

	Logger logger=LoggerFactory.getLogger(EmployeeController.class);
	@GetMapping("/home")
	public String Home()
	{

		logger.debug("[get message] debug is handling");
		return "hello frome Spring boot";
	}
}








































//logger.info("[get message] info  is handling");
//logger.warn("[get message]  error is handling");
//logger.error("[get message] error is handling");
//logger.debug("[get message] debug is handling");
//	logger.trace("[get message]  trace is handling");
//return "hello frome Spring boot";
//}

//public String findByEmail(String Email,Employee employee)
//{
//
//return "Show Employee ";
//}