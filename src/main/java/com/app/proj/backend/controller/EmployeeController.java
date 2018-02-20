package com.app.proj.backend.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.app.proj.backend.entity.Department;
import com.app.proj.backend.entity.Employee;
import com.app.proj.backend.entity.Payment;
import com.app.proj.backend.entity.Status;
import com.app.proj.backend.service.DepartmentService;
import com.app.proj.backend.service.EmployeeService;
import com.app.proj.backend.service.PaymentService;
import com.app.proj.backend.service.StatusService;

/**
 * @author HsuWaiWaiTun
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	DepartmentService departmentService;

	@Autowired
	StatusService statusService;
	
	private List<Payment> payment_list = new ArrayList<Payment>();
	private List<Department> department_list = new ArrayList<Department>();
	private List<Status> status_list = new ArrayList<Status>();
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping(value="/employee/all", method=RequestMethod.GET)
	public ModelAndView employeeList(Model model){
		log.debug("All Employees............");
		List<Employee> empList = employeeService.findAll();

		ModelAndView modelView = new ModelAndView("employee_list");
		modelView.addObject("empList", empList);
		return modelView;
	}
	
	@RequestMapping(value="/employee/add", method=RequestMethod.GET)
	public ModelAndView addEmployee(Model model){
		log.debug("For New Employee");
		payment_list = paymentService.findAllPayment();
		department_list = departmentService.findAllDepartments();
		status_list = statusService.findAllStatus();
		
		Employee employee = new Employee();
		ModelAndView modelView = new ModelAndView("employee_create");
		modelView.addObject("employee", employee);
		modelView.addObject("paymentList", payment_list);
		modelView.addObject("departList", department_list);
		modelView.addObject("statusList", status_list);
		return modelView;
	}
	
	@RequestMapping(value = "/employee/save", method = RequestMethod.POST)
	public String saveEmployee(HttpServletRequest request, @ModelAttribute Employee employee, BindingResult bindResult) {
		log.debug("Save Employee");
		boolean flag=false; 
		flag = ( employee.getId() == null ? true: false);

		Payment payment = paymentService.findByPaymentId(employee.getPayment().getPaymentId());
		Status status = statusService.findByStatusId(employee.getStatus().getStatusId());
		Department department = departmentService.findByDeptId(employee.getDepartment().getDeptId());
		employee.setDepartment(department);
		employee.setPayment(payment);
		employee.setStatus(status);
	    if(flag){
	    	employeeService.addEmployee(employee);
	    }else{
	    	employeeService.updateEmployee(employee);
	    }

		return "redirect:/employee/all";
	}
	
	@RequestMapping(value="/employee/edit", method=RequestMethod.POST)
	public ModelAndView editEmployee(Model model, @ModelAttribute("id") Integer id){
		log.debug("Edit Employee " + id);
		payment_list = paymentService.findAllPayment();
		department_list = departmentService.findAllDepartments();
		status_list = statusService.findAllStatus();
		
		Employee employee = employeeService.findById(id);
		
		ModelAndView modelView = new ModelAndView("employee_edit");
		modelView.addObject("employee", employee);
		modelView.addObject("paymentList", payment_list);
		modelView.addObject("departList", department_list);
		modelView.addObject("statusList", status_list);
		return modelView;
	}
	
	@RequestMapping(value="/employee/delete", method=RequestMethod.POST)
	public String deleteEmployee(Model model, @ModelAttribute("id") Integer id){
		log.debug("Delete Employee");
		employeeService.deleteEmployee(id);
		log.debug("Delete Successful " + id);
		return "redirect:/employee/all";
	}
}
