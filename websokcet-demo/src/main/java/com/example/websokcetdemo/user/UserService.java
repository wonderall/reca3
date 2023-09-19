package com.example.websokcetdemo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	private List<User> users_list = new ArrayList<>(); 
	
	public void register(User user) {
		user.setStatus("online");
		users_list.add(user);
	}
	
	public User login(User user) {
		int userIndex = IntStream.range(0, users_list.size())
				.filter(i -> users_list.get(i).getEmail().equals(user.getEmail()))
				.findAny()
				.orElseThrow(() -> new RuntimeException("User not fooud"));
		
		User cUser = users_list.get(userIndex);
		if(!cUser.getPassword().equals(user.getPassword())) {
			throw new RuntimeException("Password incorrect");
		}
		cUser.setStatus("online");
		return cUser;
	}
	
	public void logout(String email) {
		int userIndex = IntStream.range(0, users_list.size())
				.filter(i -> users_list.get(i).getEmail().equals(email))
				.findAny()
				.orElseThrow(() -> new RuntimeException("User not fooud"));
		users_list.get(userIndex).setStatus("offline");
	}
	
	public List<User> findall(){
		return users_list;
	}
	
}
