package com.divergentsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.divergentsl.entity.Users;

@Service
public class UserService {

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserDetailsManager manager;
	
	public void addUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		manager.createUser(user);
	}
	
}
