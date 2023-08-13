package com.codewithsajal.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithsajal.blog.payloads.ApiResponse;
import com.codewithsajal.blog.payloads.UserDto;
import com.codewithsajal.blog.services.UserService;

@RestController
@RequestMapping("/api/users/")
public class UserController {

	@Autowired
	private UserService userService;

	//POST-Create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userdto){//@Valid->to enable validation
		UserDto createdUserDto = this.userService.createUser(userdto);
		return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
	}

	//PUT-Update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") int uId){
		UserDto updatedUser = userService.updateUser(userDto, uId);
		return ResponseEntity.ok(updatedUser);
	}

	//DELETE-Delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") int uId){
		this.userService.deleteUser(uId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}

	//GET- user get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> allUsers = userService.getAllUser();
		return ResponseEntity.ok(allUsers);
	}

	//GET- user get
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable int userId){
		UserDto oneUsers = userService.getUserById(userId);
		return ResponseEntity.ok(oneUsers);
	}


}
