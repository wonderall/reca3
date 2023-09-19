package com.example.websokcetdemo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins="*")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping
	public void register(@RequestBody User user) {
		System.out.println(user.toString());
		service.register(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return service.login(user);
	}
	
	@PostMapping("/logout")
	public void logout(@RequestBody String email) {
		service.logout(email);
	}
	
	@GetMapping
	public List<User> findall(){
		return service.findall();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle(Exception ex){
		ex.printStackTrace();
		return ResponseEntity
			   .status(HttpStatus.INTERNAL_SERVER_ERROR)
			   .body(ex.getMessage());
	}
	
	
	
}
