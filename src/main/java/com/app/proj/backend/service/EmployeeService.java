package com.app.proj.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.proj.backend.entity.Employee;
import com.app.proj.backend.repositories.EmployeeRepository;


/**
 * @author HsuWaiWaiTun
 *
 */
@Service("employeeService")
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAll(){
		return (List<Employee>) employeeRepository.findAll();
	}
	
	public Employee addEmployee(Employee employee){
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee){
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(int id){
		employeeRepository.delete((long)id);
	}
	
	public Employee findByName(String name){
		return employeeRepository.findByName(name);
	}
	
	public Employee findByNameAndEmail(String name, String email){
		return employeeRepository.findByNameAndEmail(name, email);
	}
	
	public Employee findByEmail(String email){
		return employeeRepository.findByEmail(email);
	}
	
	public Employee findById(int id){
		return employeeRepository.findById((long)id);
	}

	public List<Employee> findEmployeesByDeptId( int deptId){
		return (List<Employee>) employeeRepository.findEmployeesByDeptId(deptId);
	}
	
	public List<Employee> findEmployeesByPaymentType( int paymentId){
		return (List<Employee>) employeeRepository.findEmployeesByPaymentType(paymentId);
	}
	
	public Employee findEmployeeBySalary(long salaryId){
		return employeeRepository.findEmployeeBySalaryId(salaryId);
	}

}
