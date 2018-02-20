package com.app.proj.backend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.proj.backend.entity.Employee;

/**
 * @author HsuWaiWaiTun
 *
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	public Employee findByName(String name);
	public Employee findByNameAndEmail(String name, String email);
	public Employee findByEmail(String email);
	public Employee findById(Long id);
	
	@Query("select e from Employee e , Department d where d.deptId=? and e.department=d.deptId")
	public List<Employee> findEmployeesByDeptId(int deptId);
	
	@Query("select e from Employee e , Payment p where p.paymentId=? and e.payment=p.paymentId")
	public List<Employee> findEmployeesByPaymentType(int paymentId);

	@Query("select e from Salary s , Employee e where s.salaryId=? and e.salary=s.salaryId")
	public Employee findEmployeeBySalaryId(Long salaryId);

}
