package com.deloitte.ms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.ms.entity.LoginUser;

@RestController
@RequestMapping("/loginpage")
public class LoginUserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<HttpStatus> loginpage(@RequestBody LoginUser login) throws Exception{
		Authentication authObject = null;
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authObject);
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid Credentials");
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
