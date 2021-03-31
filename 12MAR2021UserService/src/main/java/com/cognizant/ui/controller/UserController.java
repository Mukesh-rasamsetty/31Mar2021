package com.cognizant.ui.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.service.UserService;
import com.cognizant.shared.UserDto;
import com.cognizant.ui.model.CreateUserRequestModel;
import com.cognizant.ui.model.UserResponseModel;

@RestController
@RequestMapping("/api")
public class UserController {
	/*
	 * private Environment env; 
	 */
	
	private UserService userService;

	@Autowired
	public UserController(/* Environment env,*/ UserService userService) {
		super();
		/*
		 * this.env = env;
		 */
		
		 this.userService = userService;
	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_XML_VALUE}, path = "/users")
	@ResponseBody
	public ResponseEntity<UserResponseModel> createUser(@Validated @Valid @RequestBody CreateUserRequestModel userDetails) {

		/*
		 * ModelMapper modelMapper = new ModelMapper();
		 * modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
		 * ; UserDto dto = modelMapper.map(userDetails, UserDto.class);
		 * dto.setUserId(UUID.randomUUID().toString()); userService.createUser(dto);
		 * return new ResponseEntity<String>("post method called on port number: " +
		 * env.getProperty("local.server.port")+"\n"+dto, HttpStatus.OK);
		 */
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto dto = modelMapper.map(userDetails, UserDto.class);
		dto.setUserId(UUID.randomUUID().toString());
		UserDto tempDto=userService.createUser(dto);
		UserResponseModel userResponseModel = modelMapper.map(tempDto, UserResponseModel.class);
		return new ResponseEntity<UserResponseModel>(userResponseModel, HttpStatus.OK);
	}

}