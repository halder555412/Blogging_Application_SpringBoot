package com.codewithsajal.blog.user.soumya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/")
public class SoumyaController {
	
	@Autowired
	private UserService1 userService1;
	
	@PostMapping("/soumya")
	public ResponseEntity<User1> createUser(@RequestBody User1 user){
//		System.out.println(user);
		User1 user1 = userService1.createUser(user);
		return new ResponseEntity<User1>(user1,HttpStatus.OK);
	}

}
