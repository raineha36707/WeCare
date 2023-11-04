package com.Infy.WeCare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Infy.WeCare.DTO.UserDTO;
import com.Infy.WeCare.Exception.NoSuchUser;
import com.Infy.WeCare.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/users")
	public UserDTO createUser(@RequestBody UserDTO user) {
		return service.addUser(user);
	}
	
	@GetMapping("/users/{id}")
	public UserDTO getUserById(@PathVariable int id) throws NoSuchUser{
		return service.getProfile(id);
	}
	
	
}
