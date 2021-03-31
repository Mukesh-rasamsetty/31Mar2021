package com.cognizant.service;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cognizant.repo.UserEntity;
import com.cognizant.repo.UserRepository;
import com.cognizant.shared.UserDto;

@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	@Transactional
	public UserDto createUser(UserDto dto) {
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity entity=modelMapper.map(dto, UserEntity.class);
		entity.setEncryptedPassword("test");
		userRepository.save(entity);
		return dto;
	}

}