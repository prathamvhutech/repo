package com.demo.serviceimple;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entity.Employee;
import com.demo.entity.exception.ResourceNotFoundException;
import com.demo.entity.exception.Response;
import com.demo.repo.EmployeeRepository;
import com.demo.service.EmployeeService;

@Service
public class EmployeeServiceImple implements EmployeeService
{
	@Autowired
	EmployeeRepository employeeRepository;


	@Override
	public Employee saveEmployee(Employee employee)
	{
		employee.setDate(LocalDate.now());
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> findAllByOrderByIdAsc()
	{
		return employeeRepository.findAll();
	}

	
	@Override
	public List<Employee> getAllEmployee()
	{
		return employeeRepository.findAllByOrderByIdDesc();
	}


	@Override
	public Employee updateById(Employee employee, int id) 
	{
		Employee employee2=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(400, "id Is Not Present In Employee"));
		employee2.setName(employee.getName());
		employee2.setEmail(employee.getEmail());
		employee2.setPassword(employee.getPassword());
		employee2.setSal(employee.getSal());
		employeeRepository.save(employee2);
		return employee2;
	}

	

	@Override
	public Response deleteById(int id) throws ResourceNotFoundException
	{
		 Employee employee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(400, "Id not found In Employee"));
		 
		 employeeRepository.delete(employee);
		 return new Response("Sucess ", 200);
		 
//		 if(employee!=null)
//		 {
//			 employeeRepository.deleteById(id);
//			 throw new ResourceNotFoundException(200, " Deleted SucessFully");
//		 }
//		 else 
//		 {
//			 throw new ResourceNotFoundException(404,"valids are not found");
//		 }
//		  
	}


	@Override
	public List<Employee> getAllEmployeeByOrderByIdDesc() 
	{
		return employeeRepository.findAllByOrderByIdDesc();
	}


	

	
}



















//@Override
//public Employee saveEmployee(Employee employee) throws EmailAlreadyExitis
//{
//	Employee employee2=employeeRepository.findByEmail(employee.getEmail());
//	{
//		if(employee2!=null)
//		{
//			throw new EmailAlreadyExitis("Email alredy Exitis", HttpStatus.BAD_REQUEST);
//		}
//	}
//	return employeeRepository.save(employee);
//}