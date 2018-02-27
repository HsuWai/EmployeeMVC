package com.app.proj.config;

import java.util.List;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.proj.backend.entity.Department;
import com.app.proj.backend.entity.Employee;
import com.app.proj.backend.entity.Payment;
import com.app.proj.backend.entity.Status;
import com.app.proj.backend.entity.User;
import com.app.proj.backend.entity.UserRole;
import com.app.proj.backend.service.DepartmentService;
import com.app.proj.backend.service.EmployeeService;
import com.app.proj.backend.service.PaymentService;
import com.app.proj.backend.service.StatusService;
import com.app.proj.backend.service.UserRoleService;
import com.app.proj.backend.service.UserService;
import com.app.proj.utils.Roles;


/**
 * @author HsuWaiWaiTun
 *
 */
@Component
public class DeployListener {
	
	
	private static final Logger log = LoggerFactory.getLogger(DeployListener.class);

	@Autowired 
	private UserService userService;
	
	@Autowired
	private UserRoleService roleService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	StatusService statusService;
	
	@Autowired
	EmployeeService employeeService;

    @PostConstruct
    public void init(){
    	log.debug("Deploy Listener started.............");
        // start your monitoring in here
    	List<UserRole> roleList = roleService.findAll();
    	if(roleList.size() == 0){
    	
    		UserRole userRole1 = new UserRole(Roles.ROLE_ADMIN.toString(), "Administrator");
    		UserRole userRole2 = new UserRole(Roles.BASIC_USER.toString(), "Basic User");
    		UserRole userRole3 = new UserRole(Roles.PRO_USER.toString(), "Pro User");
        	roleService.addRole(userRole1);
        	roleService.addRole(userRole2);
        	roleService.addRole(userRole3);
        	log.debug("User Roles Added");
    	}
    	
    	List<User> userList = userService.findAll();
    	if(userList.size() == 0){
    		UserRole userRole = roleService.findByRole("ROLE_ADMIN");
    		roleList.add(userRole);
    		String password= "password";
    		User user = new User();
        	user.setUsername("Administrator");
        	user.setPassword(password);
        	user.setEmail("snow.swwt@gmail.com");
        	user.setUserRole(roleList);
        	user.setEnabled(true);
        	userService.create(user);
        	log.debug("Admin Added");
    	}
    	
    	List<Department> depart_list = departmentService.findAllDepartments();
    	if(depart_list.size() == 0){
    		Department d1 = new Department("Human Resource Department", "Employee management department");
    		Department d2 = new Department("IT Department", "Information Technology Department");
    		departmentService.createDept(d1);
    		departmentService.createDept(d2);
    		log.debug("Departments Added");
    	}
    	
    	List<Payment> payment_list = paymentService.findAllPayment();
    	if(payment_list.size() == 0){
    		Payment p1 = new Payment("Hourly", 1500.00);
    		Payment p2 = new Payment("Daily", 10000.00);
    		paymentService.addPayment(p1);
    		paymentService.addPayment(p2);	
    		log.debug("Payment types added");
    	}
    	
    	List<Status> status_list = statusService.findAllStatus();
    	if(status_list.size() == 0) {
    		Status s1 = new Status("Contract");
    		Status s2 = new Status("Permanent");
    		Status s3 = new Status("Probation");
    		statusService.addStatus(s1);
    		statusService.addStatus(s2);
    		statusService.addStatus(s3);
    		log.debug("Status added");
    	}

    	
    }
}
