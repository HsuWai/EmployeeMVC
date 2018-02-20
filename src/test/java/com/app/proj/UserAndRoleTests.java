package com.app.proj;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.app.proj.backend.entity.User;
import com.app.proj.backend.entity.UserRole;
import com.app.proj.backend.service.UserRoleService;
import com.app.proj.backend.service.UserService;


/**
 * @author HsuWaiWaiTun
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
public class UserAndRoleTests {

private static final Logger log = LoggerFactory.getLogger(UserAndRoleTests.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRoleService roleService;
	
	@Test
	public void CreateUser() {
		List<UserRole> roleList = roleService.findAll();
		User user = new User();
		user.setUsername("Hsu Wai");
		user.setPassword("NZPJPCOcM+QE9KjbIpH8PQ==");
		user.setEmail("snow.swwt@gmail.com");
		user.setEnabled(true);
		user.setUserRole(roleList);
		userService.create(user);
	}

	@Ignore
	@Test
	public void DeleteUser() {
		int userid = 2;
		userService.deleteUser(userid);
	}
	
	@Ignore
	@Test
	public void findUserByUsername(){
		User user = userService.findUserByUsername("Hsu");
		log.debug(user.toString());
	}
	
	@Ignore
	@Test
	public void findUserByUsernameAndPassword(){
		User user = userService.login("Hsu", "123");
		log.debug(user.toString());
	}
	
}
