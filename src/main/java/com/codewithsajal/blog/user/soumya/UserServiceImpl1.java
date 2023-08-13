package com.codewithsajal.blog.user.soumya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl1 implements UserService1 {

	@Autowired
	private SoumyaRepo soumyaRepo;
	
	@Override
	public User1 createUser(User1 user) {
		System.out.println(user);
		User1 user1 = soumyaRepo.save(user);
		return user1;
	}

	@Override
	public User1 updateUser(User1 user) {
		// TODO Auto-generated method stub
		return null;
	}

}
