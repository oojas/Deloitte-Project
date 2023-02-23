package com.deloitte.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.ms.entity.User;
import com.deloitte.ms.repo.UserRepo;

@RestController
@RequestMapping("/customer")
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getCustomer(){
		return new ResponseEntity<List<User>>(userRepo.findAll(),HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<User> addCustomer(@RequestBody User customer){
		return new ResponseEntity<User>(userRepo.save(customer),HttpStatus.OK);
	}
	
	
}
