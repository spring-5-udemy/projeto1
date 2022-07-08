package com.example.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired(required = false)
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		List<User> users = userRepository.findAll();
		
		if(users.isEmpty()) {
			
			createUser("Nataniel", "nataniel.paiva@gmail.com");
			createUser("João", "joao@gmail.com");
			createUser("Maria", "maria@gmail.com");
		}
		
		User user = (User) userRepository.findByEmailQualquerCoisa("nataniel.paiva@gmail.com");
		
		System.out.println(user.getName());
	}
	
	public void createUser(String name, String email) {
		
		User user = new User(name, email);
		
		userRepository.save(user);
	}

}
