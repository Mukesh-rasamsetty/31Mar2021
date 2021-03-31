package com.cognizant.service;

import org.springframework.stereotype.Service;

import com.cognizant.shared.UserDto;

@Service
public interface UserService {
	public UserDto createUser(UserDto dto);
}