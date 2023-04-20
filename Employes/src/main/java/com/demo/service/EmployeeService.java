package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;
import com.demo.entity.exception.Response;

public interface EmployeeService 
{
    Employee saveEmployee(Employee employee);
	
	List<Employee> findAllByOrderByIdAsc();
	
	List<Employee> getAllEmployee();
	
	List<Employee> getAllEmployeeByOrderByIdDesc();
	
	Employee updateById(Employee employee , int id);
	
	Response  deleteById(int id) ;

	
}
