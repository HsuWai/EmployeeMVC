package com.app.proj.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.proj.backend.entity.Salary;
import com.app.proj.backend.repositories.SalaryRepository;

/**
 * @author HsuWaiWaiTun
 *
 */

@Service("salaryService")
public class SalaryService {

	@Autowired
	private SalaryRepository salaryRepository;
	
	public List<Salary> findAllSalaries(){
		return (List<Salary>) salaryRepository.findAll();
	}
	
	public Salary addSalary(Salary salary){
		return salaryRepository.save(salary);
	}
	
	public Salary updateSalary(Salary salary){
		return salaryRepository.save(salary);
	}
	
	public void deleteSalary(int id){
		salaryRepository.delete(id);
	}

}
