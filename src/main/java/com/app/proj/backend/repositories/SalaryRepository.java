package com.app.proj.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.app.proj.backend.entity.Salary;

/**
 * @author HsuWaiWaiTun
 *
 */
@Repository
public interface SalaryRepository extends CrudRepository<Salary, Integer>{

}
