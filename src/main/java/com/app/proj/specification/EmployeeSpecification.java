package com.app.proj.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import com.app.proj.backend.entity.Employee;

/**
 * @author HsuWaiWaiTun
 *
 */
public class EmployeeSpecification  {

	 public static Specification<Employee> findByEmpName(final String name) {
	        return new Specification<Employee>() {
	            @Override
	            public Predicate toPredicate(Root<Employee> root,
	                    CriteriaQuery<?> criteriaQuery,
	                    CriteriaBuilder criteriaBuilder) {
	                return criteriaBuilder.like(root.get("name"), name);
	            }
	        };
	    }
	 

}
