package com.app.proj.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.proj.backend.entity.Department;
import com.app.proj.backend.entity.Employee;


/**
 * @author HsuWaiWaiTun
 *
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer>{

	public Department findByDeptId(int id);
	public Department findByDeptName(String deptName);
	public List<Employee> findEmployeesByDeptName(String deptName);
}
