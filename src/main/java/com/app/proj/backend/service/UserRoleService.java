package com.app.proj.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.proj.backend.entity.UserRole;
import com.app.proj.backend.repositories.UserRoleRepository;


/**
 * @author HsuWaiWaiTun
 *
 */
@Service("roleService")
public class UserRoleService {

	@Autowired
    private UserRoleRepository userRoleRepository;
	
	public List<UserRole> findAll(){
		return (List<UserRole>) userRoleRepository.findAll();
	}
	
	public void addRole(UserRole userRole){
		userRoleRepository.save(userRole);
	}
	
	public UserRole findByRole(String role){
		return userRoleRepository.findByRole(role);
	}
}
