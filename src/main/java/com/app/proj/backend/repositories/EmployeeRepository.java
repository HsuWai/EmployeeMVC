package com.app.proj.backend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.proj.backend.entity.Employee;

/**
 * @author HsuWaiWaiTun
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>,JpaSpecificationExecutor<Employee>{

	public Page<Employee> findAll(Pageable pageable);
	public Page<Employee> findByName(String name, Pageable pageable);
	
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
