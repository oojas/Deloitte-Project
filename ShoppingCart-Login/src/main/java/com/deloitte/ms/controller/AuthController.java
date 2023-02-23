package com.deloitte.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AuthController {
	
	@Autowired
	RestTemplate restTEmplate;

}
