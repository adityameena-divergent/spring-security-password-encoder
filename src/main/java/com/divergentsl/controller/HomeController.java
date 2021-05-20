package com.divergentsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.entity.Users;
import com.divergentsl.service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	UserService service;

	@GetMapping("/home")
	public String hello() {
		return "Spring Security Using UserDetailsManager !!";
	}
	
	
	@PostMapping("/create")
	public String hello(@RequestBody Users user) {
		service.addUser(user);
		return "user created";
	}
	
}
