package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

	Employee findByEmail(Employee employee);

	List<Employee> findAllByOrderByIdAsc();
	
	List<Employee> findAllByOrderByIdDesc();
	
	Employee findByEmail(String email);

	

}
