package com.example.websokcetdemo.user;



public class User {

	public String username;
	public String email;
	public String password;
	public String status;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User(String username, String email, String password, String status) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	public User() {
		super();
	}
	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	

}
