package com.timmy.advanced;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int uid;
	private String username;
	private String password;
	private Set<Employee> roles=new HashSet<Employee>();
	
	public Set<Employee> getRoles() {
		return roles;
	}
	public void setRoles(Set<Employee> roles) {
		this.roles = roles;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	
	

}
