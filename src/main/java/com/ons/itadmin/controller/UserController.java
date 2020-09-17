package com.ons.itadmin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ons.itadmin.model.User;
import com.ons.itadmin.repository.UserRepository;
import com.ons.itadmin.rest.RestUser;

@RestController
@RequestMapping (value = "/it-admin")
public class UserController {
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Autowired
	public UserRepository userRepository;
	
	@GetMapping (value = "/users")
	public List<RestUser> getUser(){
		HttpHeaders header= new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		ResponseEntity<RestUser[]> responseEntity= restTemplate.getForEntity("http://localhost:8080/rest/users", RestUser[].class);
		List<RestUser> users= Arrays.asList(responseEntity.getBody());
		System.out.println("returning: "+users);
		return users;
	}
	
	@GetMapping (value = "/userassets")
	public List<User> users(){
		return userRepository.findAll();
	}
	
	@GetMapping (value = "/userassets/{id}")
	public User getUser(@PathVariable Long id) {
		return userRepository.getOne(id);
	}
	
	@PostMapping (value = "/userassets")
	public User AddUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/userassets/{id}")
	public void update(@RequestBody User newUser, @PathVariable Long id) {
		if(userRepository.existsById(id)) {
			User existingUser= userRepository.getOne(id);
			existingUser.setAssets(newUser.getAssets());
			userRepository.save(existingUser);
		}
	}
	
	@DeleteMapping ("/userassets/{id}")
	public void delete(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
}
