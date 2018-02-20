package com.app.proj.backend.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.proj.backend.entity.UserRole;


/**
 * @author HsuWaiWaiTun
 *
 */
@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Long>{
	public UserRole findByRole(String role);
}
