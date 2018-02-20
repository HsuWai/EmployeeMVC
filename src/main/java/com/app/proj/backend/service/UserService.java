package com.app.proj.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.proj.backend.entity.User;
import com.app.proj.backend.repositories.UserRepository;


/**
 * @author HsuWaiWaiTun
 *
 */
@Service("userService")
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
	public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User findUserById(int id) {
        return userRepository.findOne((long) id);
    }
    
	public User login(String username, String password){
		return userRepository.login(username, password);
	}
	
	public User update(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.delete((long) id);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public User findUserByUsernameAndPassword(String username,String password){
    	return userRepository.findByUsernameAndPassword(username, password);
    }
    
    public User findUserByEmail(String email){
    	return userRepository.findByEmail(email);
    }
    
}
