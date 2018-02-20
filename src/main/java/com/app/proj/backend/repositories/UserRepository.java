package com.app.proj.backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.proj.backend.entity.User;


/**
 * @author HsuWaiWaiTun
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	@Query("select u from User u where u.username=? and u.password=?")
    public User login(String email, String password);
	public User findByUsername(String username);
	public User findByUsernameAndPassword(String username, String password);
	public User findByEmail(String email);
	
}
