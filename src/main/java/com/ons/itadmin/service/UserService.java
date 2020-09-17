package com.ons.itadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ons.itadmin.model.User;
import com.ons.itadmin.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional (readOnly = false)
	public User getUserById(long id) {
		return userRepository.getOne(id);
	}
	
	@Transactional (readOnly = true)
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@Transactional (readOnly = false)
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	@Transactional (readOnly = false)
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
}
