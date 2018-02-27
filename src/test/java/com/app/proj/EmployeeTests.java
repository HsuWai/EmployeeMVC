package com.app.proj;


import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.app.proj.backend.entity.Department;
import com.app.proj.backend.entity.Employee;
import com.app.proj.backend.repositories.EmployeeRepository;
import com.app.proj.backend.service.DepartmentService;
import com.app.proj.backend.service.EmployeeService;

/**
 * @author HsuWaiWaiTun
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class EmployeeTests {
	
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeTests.class);


	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Ignore
	@Test
	public void createEmployee() {
		Department dept = deptService.findByDeptId(3);
		Employee emp = new Employee("Hsu Wai", "test@gmail.com", "Yangon", 23,dept);
		employeeService.addEmployee(emp);
		logger.debug("Employee Creation Successful");
	}

	
	@Ignore
	@Test
	public void updateEmployee(){
		Employee e = employeeService.findById(1);
		logger.debug(e.toString());
		e.setAge(20);
		employeeService.updateEmployee(e);
		e = employeeService.findById(1);
		logger.debug(e.toString());
	}

	@Ignore
	@Test
	public void deleteEmployee(){
		//employeeService.deleteEmployee(2);
		empRepo.deleteAll();
		System.out.println(empRepo.findById(2L).toString());
		//empRepo.delete(empRepo.findById(2L));
	}

	@Ignore
	@Test
	public void getEmployeesById(){
		List<Employee> empList = employeeService.findEmployeesByDeptId(3);
		logger.debug("List : " +empList.size());
		for(Employee e: empList){
			logger.debug("Employee : "+e.toString());
		}
	}
	
	@Test
	public void givenLast_whenGettingListOfUsers_thenCorrect() {
	    
	}
}
