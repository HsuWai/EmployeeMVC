package com.app.proj.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.app.proj.backend.entity.Department;
import com.app.proj.backend.entity.Employee;
import com.app.proj.backend.entity.Payment;
import com.app.proj.backend.entity.Status;
import com.app.proj.backend.service.DepartmentService;
import com.app.proj.backend.service.EmployeeService;
import com.app.proj.backend.service.PaymentService;
import com.app.proj.backend.service.StatusService;
import com.app.proj.utils.Pager;

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
	
	private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {5, 10, 20};
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	/*@RequestMapping(value="/employee/all", method=RequestMethod.GET)
	public ModelAndView employeeList(Model model){
		log.debug("All Employees............");
		List<Employee> empList = employeeService.findAll();

		ModelAndView modelView = new ModelAndView("employee_list");
		modelView.addObject("empList", empList);
		return modelView;
	}*/
	
	/*@RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable){
        Page<Employee> empPage = employeeService.findAll(pageable);
        PageWrapper<Employee> page = new PageWrapper<Employee>(empPage, "/employees");
        System.out.println(page.getContent());
        model.addAttribute("empList", page.getContent());
        model.addAttribute("page", page);
        return "employees";
    }*/
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView showEmployeesPerPage(@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page) {

		ModelAndView modelAndView = new ModelAndView("employeesPage");
		
		// Evaluate page size. If requested parameter is null, return initial
		// page size
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		
		Page<Employee> employees = employeeService.findAll(new PageRequest(evalPage, evalPageSize));
		Pager pager = new Pager(employees.getTotalPages(), employees.getNumber(), BUTTONS_TO_SHOW);
		
		System.out.println(employees.getNumberOfElements());
		modelAndView.addObject("empList", employees);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;
	}

	
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public String home(Model model,@PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 4) Pageable pageable) {
		
		Page<Employee> boardPage = employeeService.findAll(pageable);
		
		int current = boardPage.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 9, boardPage.getTotalPages());
		
		model.addAttribute("boardPage", boardPage);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		
		return "home";
		
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

		return "redirect:/employees";
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
