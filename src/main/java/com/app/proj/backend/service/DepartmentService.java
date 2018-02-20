package com.app.proj.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.proj.backend.entity.Department;
import com.app.proj.backend.entity.Employee;
import com.app.proj.backend.repositories.DepartmentRepository;


/**
 * @author HsuWaiWaiTun
 *
 */
@Service("deptService")
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> findAllDepartments(){
		return (List<Department>) departmentRepository.findAll();
	}
	
	public Department createDept(Department dept){
		return departmentRepository.save(dept);
	}
	
	public Department updateDept(Department dept){
		return departmentRepository.save(dept);
	}
	
	public void deleteDepartment(int id){
		departmentRepository.delete(id);
	}
	
	public Department findByDeptName(String deptName){
		return departmentRepository.findByDeptName(deptName);
	}
	
	public List<Employee> findEmployeesByDeptName(String deptName){
		return (List<Employee>) departmentRepository.findEmployeesByDeptName(deptName);
	}
	
	public Department findByDeptId(int id){
		return departmentRepository.findByDeptId(id);
	}

}
