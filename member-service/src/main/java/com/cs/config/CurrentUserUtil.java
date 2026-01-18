package com.cs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.cs.entity.User;
import com.cs.repository.UserRepository;

@Component
public class CurrentUserUtil {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth == null || !auth.isAuthenticated()) {
			return null;
		}
		
		User user = userRepository.findById(auth.getName()).get();
		return user;
	}

} 