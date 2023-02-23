package com.deloitte.ms.entity;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")

public class LoginUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String username;
	private String password;
	private String name;
	private String email;
	private String phoneNo;
	private String address;
	
	public List<GrantedAuthority> getAuthorities(){
		return List.of(()->"read");
			
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
