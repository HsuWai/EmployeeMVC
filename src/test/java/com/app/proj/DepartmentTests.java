package com.app.proj;

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
import com.app.proj.backend.service.DepartmentService;
import com.app.proj.backend.service.EmployeeService;

/**
 * @author HsuWaiWaiTun
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class DepartmentTests {
	
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentTests.class);


	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService deptService;
	
	@Ignore
	@Test
	public void createDepartment() {
		Department dept = new Department("Project Department", "Project Department");
		deptService.createDept(dept);
		logger.debug("Department Creation Successful");
	}
	
	@Ignore
	@Test
	public void editDepartment(){
		Department d = deptService.findByDeptId(3);
		d.setDeptName("Human Resource Department");
		deptService.updateDept(d);
	}
	
	@Test
	public void deleteDepartment(){
		deptService.deleteDepartment(2);
	}
}
